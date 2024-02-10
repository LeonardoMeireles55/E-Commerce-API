package com.leonardo.ecommerce.record.recovery;

import jakarta.validation.constraints.NotBlank;

public record RecoveryPasswordDTO(
    @NotBlank
    String username,
    @NotBlank
    String email,
    @NotBlank
    String token,
    @NotBlank
    String newPassword
) {
    
}
