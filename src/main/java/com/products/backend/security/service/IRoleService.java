package com.products.backend.security.service;

import com.products.backend.security.domain.entity.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(String name);
}
