package com.leonardo.ecommerce.service.user;

import com.leonardo.ecommerce.domain.user.ForgotPassword;
import com.leonardo.ecommerce.infra.exception.GlobalErrorHandling;
import com.leonardo.ecommerce.infra.security.component.BCryptEncoderComponent;
import com.leonardo.ecommerce.record.admin.EmailDTO;
import com.leonardo.ecommerce.repository.user.ForgotPasswordRepositoryCustom;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecoveryService {

    private final ForgotPasswordRepositoryCustom forgotPasswordRepositoryCustom;
    private final EmailService emailService;
    private final UserRepositoryCustom userRepositoryCustom;

    public void generateForgotPassword(String email) {
        if (!userRepositoryCustom.existsByEmail(email)) {
            throw new GlobalErrorHandling.ResourceNotFoundException("User not exists");
        }
        var userCurrentPassword = userRepositoryCustom.getReferenceByEmail(email);
        String recoveryToken = UUID.randomUUID().toString();
        ForgotPassword forgotPassword = new ForgotPassword(userCurrentPassword.getId(), userCurrentPassword.getEmail(), recoveryToken);
        var emailDTO = new EmailDTO(email, "recovery", recoveryToken);

        forgotPasswordRepositoryCustom.save(forgotPassword);

        emailService.sendEmail(emailDTO);
    }

    public void forgotPasswordUpdate(String username, String email, String password, String newPassword) {
        var userCurrentPassword = userRepositoryCustom.getReferenceByUsername(username);
        var userRecoveryPassword = forgotPasswordRepositoryCustom.getReferenceByUserEmail(email);

        if (!userRecoveryPassword.getUserPassword().trim().equals(password.trim())) {
            throw new GlobalErrorHandling.PasswordNotMatchesException();
        }
        userRepositoryCustom
                .setPasswordWhereByUsername(userCurrentPassword.getUsername(),
                        BCryptEncoderComponent.encrypt(newPassword));
    }

    public void passwordUpdate(String username, String currentPassword, String newPassword) {
        var userCurrentPassword = userRepositoryCustom.getReferenceByUsername(username);
        if (!BCryptEncoderComponent
                .decryptMatches(currentPassword, userCurrentPassword.getPassword())
                || BCryptEncoderComponent.decryptMatches(newPassword, userCurrentPassword.getPassword())) {
            throw new GlobalErrorHandling.PasswordNotMatchesException();
        } else {
            userRepositoryCustom
                    .setPasswordWhereByUsername(userCurrentPassword.getUsername(),
                            BCryptEncoderComponent.encrypt(newPassword));
        }
    }
}
