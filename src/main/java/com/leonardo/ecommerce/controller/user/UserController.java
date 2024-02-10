package com.leonardo.ecommerce.controller.user;

import com.leonardo.ecommerce.record.user.AddressDTO;
import com.leonardo.ecommerce.record.user.SignInDTO;
import com.leonardo.ecommerce.record.security.TokenJwtDTO;
import com.leonardo.ecommerce.record.user.UserDTO;
import com.leonardo.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @Transactional
    @PostMapping("/signUp")
    public ResponseEntity<Void> signUp
        (@RequestBody UserDTO userDTO, AddressDTO addressDTO) {
            userService.signUp(userDTO.username(), userDTO.firstName(), userDTO.LastName(),
                    userDTO.dateBirth(), userDTO.email(), userDTO.password(), addressDTO);
                return ResponseEntity.noContent().build();
    }

    @PostMapping("/signIn")
    public ResponseEntity<TokenJwtDTO> singIn(@RequestBody SignInDTO signInDTO) {
        var signInJwt = userService.singIn(signInDTO.username(), signInDTO.password());
            return ResponseEntity.ok().body(signInJwt);
    }
}