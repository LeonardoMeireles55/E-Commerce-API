package com.leonardo.ecommerce.domain.user;

import com.leonardo.ecommerce.enums.UserRolesEnums;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_birth")
    private String dateBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "enabled")
    private Boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_roles")
    private UserRolesEnums userRolesEnums;

    public User(String userName, String firstName, String lastName, String dateBirth, String email, String password, String postalCode, String state, String city, String street) {
        this.username = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.postalCode = postalCode;
        this.state = state;
        this.city = city;
        this.street = street;
        this.enabled = true;
        this.userRolesEnums = UserRolesEnums.FREE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.userRolesEnums == UserRolesEnums.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_FREE"),
                    new SimpleGrantedAuthority("ROLE_PREMIUM"));
        } else return List.of(new SimpleGrantedAuthority("ROLE_FREE"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getEnabled();
    }
}
