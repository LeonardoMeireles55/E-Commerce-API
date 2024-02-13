package com.leonardo.ecommerce.record.ecommerce;

import com.leonardo.ecommerce.enums.CategoryEnums;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDTO (
        @NotBlank @NotNull
        String name,
        @NotBlank @NotNull
        String description,
        @NotNull
        Double price,
        @NotNull
        Integer quantityInStock,
        CategoryEnums categoryEnums,
        @NotBlank @NotNull
        String photoLink,
        @NotNull
        Double offPrice,
        @NotNull
        Integer stars
) {}
