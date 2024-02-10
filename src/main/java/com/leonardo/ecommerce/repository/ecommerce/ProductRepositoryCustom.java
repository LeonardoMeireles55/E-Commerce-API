package com.leonardo.ecommerce.repository.ecommerce;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.leonardo.ecommerce.domain.ecommerce.Product;

@Repository
public interface ProductRepositoryCustom extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.stars = p.stars + 1 WHERE p.id = :productId")
    void incrementStarsWhereId(Long productId);
    @Transactional
    @Modifying
    @Query("UPDATE Product p SET p.stars = p.stars - 1 WHERE p.id = :productId")
    void decrementStartsWhereId(Long productId);
} 
    
