package com.leonardo.ecommerce.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leonardo.ecommerce.domain.user.ForgotPassword;

public interface ForgotPasswordRepositoryCustom extends JpaRepository<ForgotPassword, Long> {

    ForgotPassword getReferenceByUserEmail(String email);

}
