package com.leonardo.ecommerce.repository;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.enums.CategoryEnums;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import com.leonardo.ecommerce.repository.ecommerce.ProductRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ProductRepositoryTest {
    @Autowired
    private ProductRepositoryCustom productRepositoryTest;

    @BeforeEach
    void setUp() { productRepositoryTest.deleteAll(); }

    @Test
    void saveProduct() throws Exception {
        ProductDTO dto = new ProductDTO("test", "test", 45.50,
                10, CategoryEnums.BLUSAS, "...", 10.0, 10);
        Product expectedProduct = new Product(dto.name(),
                dto.description(), dto.price(),
                dto.quantityInStock(), dto.categoryEnums(),
                dto.photoLink(), dto.offPrice(), dto.stars());

        var savedProduct = productRepositoryTest.save(expectedProduct);

        assertThat(productRepositoryTest.findAll()).isNotEmpty();
    }
}
