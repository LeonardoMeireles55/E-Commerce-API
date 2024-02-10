package com.leonardo.ecommerce.record.user;

import jakarta.validation.constraints.NotBlank;

public record SignInDTO(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
