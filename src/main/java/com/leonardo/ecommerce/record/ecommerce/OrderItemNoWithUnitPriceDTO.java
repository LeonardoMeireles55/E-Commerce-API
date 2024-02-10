package com.leonardo.ecommerce.record.ecommerce;

public record OrderItemNoWithUnitPriceDTO(
        Integer quantity,
        Long productId,
        Long orderId
) {
}
