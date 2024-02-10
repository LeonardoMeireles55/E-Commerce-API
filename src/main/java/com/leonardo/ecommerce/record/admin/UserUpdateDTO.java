package com.leonardo.ecommerce.record.admin;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(
    @NotBlank
    String currentUsername,
    @NotBlank
    String newFirstName,
    @NotBlank
    String newLastName,
    @NotBlank
    String newDateBirth,
    @NotBlank
    String newEmail,
    @NotBlank
    String userRoles
) {

}
