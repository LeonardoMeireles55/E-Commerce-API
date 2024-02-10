package com.leonardo.ecommerce.record.user;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
    @NotBlank
    String postalCode,
    @NotBlank
    String street,
    @NotBlank
    String city,
    @NotBlank
    String state

) {}
