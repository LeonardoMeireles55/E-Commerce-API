package com.leonardo.ecommerce.repository;

import com.leonardo.ecommerce.common.ProductConstant;

import com.leonardo.ecommerce.repository.ecommerce.ProductRepositoryCustom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    @Autowired
    private ProductRepositoryCustom productRepositoryTest;
    @Test
    void persistProduct_return_isNotNull() {

        var productSut = productRepositoryTest.save(ProductConstant.PRODUCT);
        assertThat(productSut).isNotNull();
    }
    @Test
    void persistProduct_withInvalidData_ThrowsException() {

        assertThatThrownBy(() -> productRepositoryTest.save(ProductConstant.INVALID_PRODUCT))
                .isInstanceOf(RuntimeException.class);
    }
}
