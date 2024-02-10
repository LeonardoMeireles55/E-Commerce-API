package com.leonardo.ecommerce.record.recovery;

import jakarta.validation.constraints.NotBlank;

public record ForgotPassworDTO(
    @NotBlank
    String email
) {
    
}
