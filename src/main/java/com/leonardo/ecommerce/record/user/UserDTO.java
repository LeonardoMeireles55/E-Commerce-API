package com.leonardo.ecommerce.record.user;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        String username,
        @NotBlank
        String firstName,
        @NotBlank
        String LastName,
        @NotBlank
        String dateBirth,
        @NotBlank
        String email,
        @NotBlank
        String password
) {
}