package com.leonardo.ecommerce.domain.ecommerce;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "orderItem")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Double unitPrice;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;


    public OrderItem(Integer quantity, Long productId, Long orderId, Double unitPrice) {
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
        this.unitPrice = unitPrice;
    }

}
