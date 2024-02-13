package com.leonardo.ecommerce.repository;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.user.AddressDTO;
import com.leonardo.ecommerce.record.user.UserDTO;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
    @Autowired
    UserRepositoryCustom userRepositoryCustom;

    UserDTO userDTO = new UserDTO("Test", "Test", "Test", "1995/12/12",
            "email@email.com", "123456test");
    AddressDTO userAddressDTO = new AddressDTO("60411086", "Av...", "Fortal", "Ceara");

    @Test
    void persistUser_return_isNotNull() {
        User user = new User(userDTO.username(), userDTO.firstName(), userDTO.LastName(), userDTO.dateBirth(),
                userDTO.email(), userDTO.password(), userAddressDTO.postalCode(),
                userAddressDTO.state(), userAddressDTO.city(), userAddressDTO.street());
        var userSut = userRepositoryCustom.save(user);
        assertThat(userSut).isNotNull();
    }
}
