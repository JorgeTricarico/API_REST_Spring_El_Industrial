package com.products.backend.security.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleName {
    USER("USER"), ADMIN("ADMIN");

    private final String name;
}
