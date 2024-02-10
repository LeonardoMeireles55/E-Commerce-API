package com.leonardo.ecommerce.controller.admin;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.admin.UserUpdateDTO;
import com.leonardo.ecommerce.record.admin.EmailDTO;
import com.leonardo.ecommerce.service.user.AdminService;
import com.leonardo.ecommerce.service.user.EmailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class    AdminController {

    private final AdminService adminService;
    private final EmailService emailService;

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @PostMapping("/sendEmail")
    public void sendEmail(@Valid @RequestBody EmailDTO email) {
        emailService.sendEmail(email);
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @PatchMapping("/users/softDeletion")
    public void softDeletion(Long id) {
        adminService.softDeletion(id);
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @PatchMapping("/users/toggleEnabled")
    public void toggleEnabledById(Long id) {
        adminService.toggleEnabledById(id);
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @DeleteMapping("/users/hardDeletion")
    public void deleteUserById(Long id) {
        adminService.hardDeletion(id);
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @GetMapping("/users/getAllUsers")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @PatchMapping("/users/roles/update")
    public void updateUserRoles(Long id, String userRoles) {
        adminService.updateUserRoles(id, userRoles);
    }

    @PreAuthorize(("hasRole('ROLE_ADMIN)"))
    @PutMapping("/users/updateUserData")
    public void updateUserData(UserUpdateDTO userUpdateDTO) {
        adminService.updateUserData(userUpdateDTO.currentUsername(), userUpdateDTO.newFirstName(), userUpdateDTO.newLastName(), userUpdateDTO.newEmail(), userUpdateDTO.userRoles());
    }
}
