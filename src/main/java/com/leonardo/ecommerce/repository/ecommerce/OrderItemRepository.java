package com.leonardo.ecommerce.repository.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    public List<OrderItem> findAllByOrderId(Long id);
}
