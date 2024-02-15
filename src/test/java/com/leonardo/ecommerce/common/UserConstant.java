package com.leonardo.ecommerce.common;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.user.SignUpDTO;

public class UserConstant {
    public static final SignUpDTO SIGN_UP_DTO = new SignUpDTO("Test", "Test", "Test",
            "1995/12/12",
            "email@email.com", "123456test", "60411086", "Ceara", "Fortal",
            "AV...");

    public static final User USER = new User(SIGN_UP_DTO.username(), SIGN_UP_DTO.firstName(), SIGN_UP_DTO.lastName(),
            SIGN_UP_DTO.dateBirth(),
            SIGN_UP_DTO.email(), SIGN_UP_DTO.password(), SIGN_UP_DTO.postalCode(),
            SIGN_UP_DTO.state(), SIGN_UP_DTO.city(), SIGN_UP_DTO.street());
}
