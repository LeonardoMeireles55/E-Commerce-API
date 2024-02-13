package com.leonardo.ecommerce.controller;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.user.AddressDTO;
import com.leonardo.ecommerce.record.user.UserDTO;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import com.leonardo.ecommerce.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class UserControllerTest {

    UserDTO userDTO = new UserDTO("Test", "Test", "Test", "1995/12/12",
            "email@email.com", "123456test");
    AddressDTO userAddressDTO = new AddressDTO("60411086", "Av...", "Fortal", "Ceara");

    User user = new User(userDTO.username(), userDTO.firstName(), userDTO.LastName(), userDTO.dateBirth(),
            userDTO.email(), userDTO.password(), userAddressDTO.postalCode(),
            userAddressDTO.state(), userAddressDTO.city(), userAddressDTO.street());

    @Autowired
    private MockMvc mvc;
    @Autowired
    UserService userService;

    @Autowired
    private JacksonTester<UserDTO> authDataJacksonTester;

    @Autowired
    private JacksonTester<AddressDTO> addressDTOJacksonTester;

    @MockBean
    UserRepositoryCustom userRepositoryCustom;

    @Test
    @DisplayName("Should return http code 201 when information is valid")
    @WithMockUser
    void register_scenario2() throws Exception {

        when(userRepositoryCustom.save(any())).thenReturn(user);

        var response = mvc
                .perform(post("/users/signUp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authDataJacksonTester.write(userDTO).getJson()))
                .andReturn().getResponse();

        var jsonOfResponse = authDataJacksonTester.write(userDTO).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
    }


}
