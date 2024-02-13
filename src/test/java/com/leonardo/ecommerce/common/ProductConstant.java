package com.leonardo.ecommerce.common;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.enums.CategoryEnums;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;

public class ProductConstant {
    public static ProductDTO PRODUCTDTO = new ProductDTO("test", "test", 45.50,
            10, CategoryEnums.BLUSAS, "...", 10.0, 10);

    public static final Product PRODUCT = new Product(PRODUCTDTO.name(),
            PRODUCTDTO.description(), PRODUCTDTO.price(),
            PRODUCTDTO.quantityInStock(), PRODUCTDTO.categoryEnums(),
            PRODUCTDTO.photoLink(), PRODUCTDTO.offPrice(), PRODUCTDTO.stars());

    public static ProductDTO INVALID_PRODUCT_DTO = new ProductDTO("", "", 0.0, 0,
            CategoryEnums.BLUSAS, "",0.0, 0);

    public static final Product INVALID_PRODUCT = new Product();
}
