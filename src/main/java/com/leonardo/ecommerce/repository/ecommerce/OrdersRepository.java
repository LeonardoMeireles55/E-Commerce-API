package com.leonardo.ecommerce.repository.ecommerce;

import com.leonardo.ecommerce.domain.ecommerce.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
public List<Orders> findAllByUserId(Long id);
}
