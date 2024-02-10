package com.leonardo.ecommerce.record.ecommerce;

public record OrderItemDTO(
        Long id,
        Integer quantity,
        Double unitPrice,
        Long productId,
        Long orderId
) {
}

