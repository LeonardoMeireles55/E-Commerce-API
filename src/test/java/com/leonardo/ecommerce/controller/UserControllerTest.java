package com.leonardo.ecommerce.controller;


import com.leonardo.ecommerce.common.UserConstant;


import com.leonardo.ecommerce.controller.user.UserController;
import com.leonardo.ecommerce.record.user.SignUpDTO;

import com.leonardo.ecommerce.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(value = UserController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
@AutoConfigureJsonTesters
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private UserService userServiceTest;
    @Autowired
    private JacksonTester<SignUpDTO> authDataJacksonTester;

    @Test
    @DisplayName("Should return http code 201 when information is valid")
    void register_scenario1() throws Exception {
        when(userServiceTest.signUp(any())).thenReturn(UserConstant.USER);

        var response = mvc.perform(post("/users/signUp")
                        .content(authDataJacksonTester.write(UserConstant.SIGN_UP_DTO).getJson())
                        .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }
}
