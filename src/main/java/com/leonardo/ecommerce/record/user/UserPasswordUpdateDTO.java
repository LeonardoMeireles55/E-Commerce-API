package com.leonardo.ecommerce.record.user;

import jakarta.validation.constraints.NotBlank;

public record UserPasswordUpdateDTO(
        @NotBlank
        String username,
        @NotBlank
        String currentPassword,
        @NotBlank
        String newPassword
) {

}
