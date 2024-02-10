package com.leonardo.ecommerce.repository.user;

import com.leonardo.ecommerce.domain.user.User;
import com.leonardo.ecommerce.enums.UserRolesEnums;

import io.micrometer.common.lang.NonNull;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryCustom extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    User getReferenceByUsername(String userName);

    User getReferenceByEmail(String Email);

    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.password = ?2 WHERE u.username = ?1")
    void setPasswordWhereByUsername(String username, String newPassword);

    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.enabled = false WHERE u.id = ?1")
    void softDeletion(@NonNull Long id);
 
    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.userRolesEnums = ?2 WHERE u.id = ?1")
    void updateUserRoles(Long id, UserRolesEnums userRolesEnums);

    @Transactional
    @Modifying
    @Query("UPDATE users u SET u.enabled = NOT u.enabled WHERE u.id = ?1")
    void toggleEnabledById(Long id);
}
