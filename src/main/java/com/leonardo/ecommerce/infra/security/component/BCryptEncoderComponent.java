package com.leonardo.ecommerce.infra.security.component;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptEncoderComponent {
    public static Boolean decryptMatches(String pass, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.matches(pass, password);
    }

    public static String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            return passwordEncoder.encode(password);
    }
}
