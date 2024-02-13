package com.leonardo.ecommerce.controller;

import com.leonardo.ecommerce.common.ProductConstant;
import com.leonardo.ecommerce.controller.ecommerce.ProductsController;
import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.enums.CategoryEnums;
import com.leonardo.ecommerce.infra.exception.ErrorHandling;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import com.leonardo.ecommerce.service.ecommerce.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productServiceTest;

    @Autowired
    private JacksonTester<ProductDTO> jacksonTesterProductDTO;

    @Test
    @DisplayName("It should return the http code 201")
    void product_post_return_201() throws Exception {

        when(productServiceTest.createProduct(any(ProductDTO.class))).thenReturn(ProductConstant.PRODUCT);

        mvc.perform(post("/products")
                        .content(jacksonTesterProductDTO.write(ProductConstant.PRODUCTDTO).getJson())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.name")
                        .value(ProductConstant.PRODUCT.getName()));
    }
    @Test
    @DisplayName("It should return the http code 400")
    void product_post_return_400() throws Exception {

        mvc.perform(post("/products")
                        .content(jacksonTesterProductDTO.write(ProductConstant.INVALID_PRODUCT_DTO).getJson())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
