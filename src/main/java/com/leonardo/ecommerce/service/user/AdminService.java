package com.leonardo.ecommerce.service.user;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.enums.UserRolesEnums;
import com.leonardo.ecommerce.infra.exception.ErrorHandling;
import com.leonardo.ecommerce.repository.user.ForgotPasswordRepositoryCustom;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final ForgotPasswordRepositoryCustom forgotPasswordRepositoryCustom;
    private final UserRepositoryCustom userRepositoryCustom;

    public List<User> getAllUsers() {
        return userRepositoryCustom.findAll();
    }

    public void softDeletion(Long id) {
        if (!forgotPasswordRepositoryCustom.existsById(id)) {
            userRepositoryCustom.softDeletion(id);
        }
        throw new ErrorHandling.NoContentException();
    }

    public void hardDeletion(Long id) {
        if (!forgotPasswordRepositoryCustom.existsById(id)) {
            userRepositoryCustom.deleteById(id);
        }
        throw new ErrorHandling.NoContentException();
    }

    public void updateUserRoles(Long id, String userRoles) {
        if(!userRepositoryCustom.existsById(id)) {
            throw new ErrorHandling.NoContentException();
        }
        switch (userRoles.trim()) {
            case "ADMIN" -> userRepositoryCustom.updateUserRoles(id, UserRolesEnums.ADMIN);
            case "PREMIUM" -> userRepositoryCustom.updateUserRoles(id, UserRolesEnums.PREMIUM);
            case "FREE" -> userRepositoryCustom.updateUserRoles(id, UserRolesEnums.FREE);
            default -> throw new IllegalArgumentException("User role not recognized: " + userRoles);
        }
    }

    public void updateUserData(String username, String firstName, String lastName,
                               String email, String userRoles) {

        User existingUser = userRepositoryCustom.getReferenceByUsername(username);
        existingUser.setFirstName(firstName);
        existingUser.setLastName(lastName);
        existingUser.setEmail(email);
        switch (userRoles.trim()) {
            case "ADMIN" -> existingUser.setUserRolesEnums(UserRolesEnums.ADMIN);
            case "PREMIUM" -> existingUser.setUserRolesEnums(UserRolesEnums.PREMIUM);
            case "FREE" -> existingUser.setUserRolesEnums(UserRolesEnums.FREE);
            default -> throw new IllegalArgumentException("User role not recognized: " + userRoles);
        }
        userRepositoryCustom.save(existingUser);
    }
    public void toggleEnabledById(Long id) {
        userRepositoryCustom.toggleEnabledById(id);
    }

}
