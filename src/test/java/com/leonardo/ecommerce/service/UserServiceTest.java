package com.leonardo.ecommerce.service;

import com.leonardo.ecommerce.common.ProductConstant;
import com.leonardo.ecommerce.common.UserConstant;
import com.leonardo.ecommerce.domain.ecommerce.Product;
import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import com.leonardo.ecommerce.service.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepositoryCustom userRepositoryCustom;

    @InjectMocks
    private UserService userService;

    @DisplayName("It should create a product and return it")
    @Test
    void create_user_return_isEqual() {
        when(userRepositoryCustom.save(any(User.class))).thenReturn(UserConstant.USER);

        var userCreated = userService.signUp(UserConstant.SIGN_UP_DTO);

        assertThat(userCreated).isNotNull();
    }
}
