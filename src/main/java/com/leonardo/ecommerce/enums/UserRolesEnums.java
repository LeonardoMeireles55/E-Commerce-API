package com.leonardo.ecommerce.enums;

import lombok.Getter;

@Getter
public enum UserRolesEnums {
    FREE("FREE"),
    PREMIUM("PREMIUM"),
    ADMIN("ADMIN");

    private final String roles;

    UserRolesEnums(String role) {
        this.roles = role;
    }
}
