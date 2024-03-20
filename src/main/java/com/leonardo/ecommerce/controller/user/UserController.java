package com.leonardo.ecommerce.controller.user;

import com.leonardo.ecommerce.record.user.SignInDTO;
import com.leonardo.ecommerce.record.security.TokenJwtDTO;
import com.leonardo.ecommerce.record.user.SignUpDTO;
import com.leonardo.ecommerce.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Transactional
    @PostMapping("/signUp")
    public ResponseEntity<SignUpDTO> signUp
        (@RequestBody SignUpDTO userDTO, UriComponentsBuilder uriComponentsBuilder) {
        var user = userService.signUp(userDTO);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
                return ResponseEntity.created(uri).body(userDTO);
    }

    @PostMapping("/signIn")
    public ResponseEntity<TokenJwtDTO> singIn(@RequestBody SignInDTO signInDTO) {
        var signInJwt = userService.singIn(signInDTO.username(), signInDTO.password());
            return ResponseEntity.ok().body(signInJwt);
    }
}