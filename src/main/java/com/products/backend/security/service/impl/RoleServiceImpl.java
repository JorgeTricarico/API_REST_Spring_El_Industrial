package com.products.backend.security.service.impl;

import com.products.backend.security.domain.entity.Role;
import com.products.backend.security.repository.IRoleRepository;
import com.products.backend.security.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public Optional<Role> findByName(String name) {
        return this.roleRepository.findByName(name);
    }
}
