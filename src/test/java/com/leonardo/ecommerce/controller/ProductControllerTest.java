package com.leonardo.ecommerce.controller;

import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.enums.CategoryEnums;
import com.leonardo.ecommerce.record.ecommerce.ProductDTO;
import com.leonardo.ecommerce.service.ecommerce.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
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
    void productPostTest201() throws Exception {
        ProductDTO dto = new ProductDTO("test", "teste", 45.50,
                10, CategoryEnums.BLUSAS, "...", 10.0, 10);

        Product product = new Product(dto.name(),
                dto.description(), dto.price(),
                dto.quantityInStock(), dto.categoryEnums(),
                dto.photoLink(), dto.offPrice(), dto.stars());

        when(productServiceTest.createProduct(any(ProductDTO.class))).thenReturn(product);

        mvc.perform(post("/products/postProduct")
                        .content(jacksonTesterProductDTO.write(dto).getJson())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andExpect(jsonPath("$.name").value(dto.name()));
    }
}
