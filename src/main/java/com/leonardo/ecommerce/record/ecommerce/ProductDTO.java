package com.leonardo.ecommerce.record.ecommerce;

import com.leonardo.ecommerce.enums.CategoryEnums;

public record ProductDTO (
        String name,
        String description,
        Double price,
        Integer quantityInStock,
        CategoryEnums categoryEnums,
        String photoLink,
        Double offPrice,
        Integer stars
) {}
