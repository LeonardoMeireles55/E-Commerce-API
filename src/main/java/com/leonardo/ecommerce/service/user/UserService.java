package com.leonardo.ecommerce.service.user;


import com.leonardo.ecommerce.infra.security.component.BCryptEncoderComponent;
import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.record.security.TokenJwtDTO;
import com.leonardo.ecommerce.record.user.SignUpDTO;
import com.leonardo.ecommerce.repository.user.UserRepositoryCustom;
import com.leonardo.ecommerce.service.security.JwtService;
import lombok.RequiredArgsConstructor;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryCustom userRepositoryCustom;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public TokenJwtDTO singIn(String username, String password) {
        var authToken = new UsernamePasswordAuthenticationToken(username, password);
        var auth = authenticationManager.authenticate(authToken);

        var token = jwtService.generateToken((User) auth.getPrincipal());

        return new TokenJwtDTO(token);
    }

    public User signUp(SignUpDTO signUpDTO) {
        var passEncoded = BCryptEncoderComponent.encrypt(signUpDTO.password());
        var user = new User(signUpDTO.username(), signUpDTO.firstName(), signUpDTO.lastName(), signUpDTO.dateBirth(),
                signUpDTO.email(), passEncoded, signUpDTO.postalCode(), signUpDTO.city(),
                signUpDTO.state(), signUpDTO.street());

       return userRepositoryCustom.save(user);
    }
}
