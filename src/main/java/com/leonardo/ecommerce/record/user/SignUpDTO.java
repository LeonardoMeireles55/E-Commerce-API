package com.leonardo.ecommerce.record.user;

import jakarta.validation.constraints.NotBlank;

public record SignUpDTO(
        @NotBlank
        String username,
        @NotBlank
        String firstName,
        @NotBlank
        String lastName,
        @NotBlank
        String dateBirth,
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotBlank
        String postalCode,
        @NotBlank
        String state,
        @NotBlank
        String city,
        @NotBlank
        String street
) {
}
