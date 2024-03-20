package com.leonardo.ecommerce.controller.admin;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.admin.UserUpdateDTO;
import com.leonardo.ecommerce.record.admin.EmailDTO;
import com.leonardo.ecommerce.service.user.AdminService;
import com.leonardo.ecommerce.service.user.EmailService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class    AdminController {

    private final AdminService adminService;
    private final EmailService emailService;

    @PostMapping("/sendEmail")
    public void sendEmail(@Valid @RequestBody EmailDTO email) {
        emailService.sendEmail(email);
    }

    @PatchMapping("/users/softDeletion")
    public void softDeletion(Long id) {
        adminService.softDeletion(id);
    }

    @PatchMapping("/users/toggleEnabled")
    public void toggleEnabledById(Long id) {
        adminService.toggleEnabledById(id);
    }

    @DeleteMapping("/users/hardDeletion")
    public void deleteUserById(Long id) {
        adminService.hardDeletion(id);
    }

    @GetMapping("/users/getAllUsers")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }

    @PatchMapping("/users/roles/update")
    public void updateUserRoles(Long id, String userRoles) {
        adminService.updateUserRoles(id, userRoles);
    }

    @PutMapping("/users/updateUserData")
    public void updateUserData(UserUpdateDTO userUpdateDTO) {
        adminService.updateUserData(userUpdateDTO.currentUsername(), userUpdateDTO.newFirstName(),
                userUpdateDTO.newLastName(), userUpdateDTO.newEmail(),
                userUpdateDTO.userRoles());
    }
}
