package com.leonardo.ecommerce.domain.user;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity(name = "forgot_password")
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class ForgotPassword {
    @Id
    @Column(name = "fk_user")
    private Long fkUser;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "expiration_time")
    private LocalDateTime expirationTime;

    public ForgotPassword(Long fk_user, String userEmail, String userPassword) {
        this.fkUser = fk_user;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.expirationTime = LocalDateTime.now();
    }

}



