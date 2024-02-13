package com.leonardo.ecommerce.service;

import com.leonardo.ecommerce.common.ProductConstant;
import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.repository.ecommerce.ProductRepositoryCustom;
import com.leonardo.ecommerce.service.ecommerce.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


//@SpringBootTest(classes = {ProductService.class, ProductRepositoryCustom.class})
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepositoryCustom productRepositoryCustom;

    @InjectMocks
    private ProductService productServiceTest;

    @DisplayName("It should create a product and return it")
    @Test
    void create_product_return_isEqual() {

        when(productRepositoryCustom.save(any(Product.class))).thenReturn(ProductConstant.PRODUCT);

        Product createdProduct = productServiceTest.createProduct(ProductConstant.PRODUCTDTO);

        assertThat(createdProduct).isNotNull();
        assertThat(createdProduct.getName()).isEqualTo(ProductConstant.PRODUCT.getName());
        assertThat(createdProduct.getDescription()).isEqualTo(ProductConstant.PRODUCT.getDescription());
        assertThat(createdProduct.getPrice()).isEqualTo(ProductConstant.PRODUCT.getPrice());
        assertThat(createdProduct.getQuantityInStock()).isEqualTo(ProductConstant.PRODUCT.getQuantityInStock());
        assertThat(createdProduct.getCategoryEnums()).isEqualTo(ProductConstant.PRODUCT.getCategoryEnums());
        assertThat(createdProduct.getPhotoLink()).isEqualTo(ProductConstant.PRODUCT.getPhotoLink());
        assertThat(createdProduct.getOffPrice()).isEqualTo(ProductConstant.PRODUCT.getOffPrice());
        assertThat(createdProduct.getStars()).isEqualTo(ProductConstant.PRODUCT.getStars());
    }
    @Test
    void create_product_with_invalid() {
        when(productRepositoryCustom.save(ProductConstant.INVALID_PRODUCT)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> productRepositoryCustom.save(ProductConstant.INVALID_PRODUCT))
                .isInstanceOf(RuntimeException.class);
    }
}
