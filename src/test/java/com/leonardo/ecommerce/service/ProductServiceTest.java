package com.leonardo.ecommerce.service;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.enums.CategoryEnums;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import com.leonardo.ecommerce.repository.ecommerce.ProductRepositoryCustom;
import com.leonardo.ecommerce.service.ecommerce.ProductService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@RequiredArgsConstructor
public class ProductServiceTest {
    @MockBean
    private ProductRepositoryCustom productRepositoryCustom;

    @Autowired
    private ProductService productServiceTest;

    @DisplayName("It should create a product and return it")
    @Test
    void createProduct() throws Exception {
        ProductDTO dto = new ProductDTO("test", "test", 45.50,
                10, CategoryEnums.BLUSAS, "...", 10.0, 10);
        Product expectedProduct = new Product(dto.name(),
                dto.description(), dto.price(),
                dto.quantityInStock(), dto.categoryEnums(),
                dto.photoLink(), dto.offPrice(), dto.stars());

        when(productRepositoryCustom.save(any(Product.class))).thenReturn(expectedProduct);

        Product createdProduct = productServiceTest.createProduct(dto);

        assertThat(createdProduct).isNotNull();
        assertThat(createdProduct.getName()).isEqualTo(dto.name());
        assertThat(createdProduct.getDescription()).isEqualTo(dto.description());
        assertThat(createdProduct.getPrice()).isEqualTo(dto.price());
        assertThat(createdProduct.getQuantityInStock()).isEqualTo(dto.quantityInStock());
        assertThat(createdProduct.getCategoryEnums()).isEqualTo(dto.categoryEnums());
        assertThat(createdProduct.getPhotoLink()).isEqualTo(dto.photoLink());
        assertThat(createdProduct.getOffPrice()).isEqualTo(dto.offPrice());
        assertThat(createdProduct.getStars()).isEqualTo(dto.stars());
    }
}
