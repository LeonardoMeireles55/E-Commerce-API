package com.leonardo.ecommerce.controller.recovery;

import com.leonardo.ecommerce.record.recovery.RecoveryPasswordDTO;
import com.leonardo.ecommerce.record.user.UserPasswordUpdateDTO;
import com.leonardo.ecommerce.record.recovery.ForgotPassworDTO;
import com.leonardo.ecommerce.service.user.RecoveryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recovery")
@RequiredArgsConstructor
public class RecoveryController {

    private final RecoveryService recoveryService;

    @Transactional
    @PatchMapping("/password/update")
    public ResponseEntity<Void>
    updatePassword(@Valid @RequestBody UserPasswordUpdateDTO userPasswordUpdateDTO, String newPassword) {
        recoveryService.passwordUpdate(userPasswordUpdateDTO.username(), userPasswordUpdateDTO.currentPassword(),
                userPasswordUpdateDTO.newPassword());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/password/generateForgotPasswordToken")
    public void generateForgotPassword(@Valid @RequestBody ForgotPassworDTO forgotPassworDTO) {
        recoveryService.generateForgotPassword(forgotPassworDTO.email());
    }

    @PatchMapping("/password/recoveryForgotPassword")
    public void recoveryForgotPassword(@Valid @RequestBody RecoveryPasswordDTO forgotPasswordDTO) {
        recoveryService.forgotPasswordUpdate(forgotPasswordDTO.username(),
                forgotPasswordDTO.email(), forgotPasswordDTO.token(), forgotPasswordDTO.newPassword());
    }
}
