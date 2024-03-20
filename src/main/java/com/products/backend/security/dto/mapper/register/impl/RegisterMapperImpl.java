package com.products.backend.security.dto.mapper.register.impl;

import com.products.backend.security.domain.entity.User;
import com.products.backend.security.dto.mapper.register.IRegisterMapper;
import com.products.backend.security.dto.request.RegisterRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterMapperImpl implements IRegisterMapper {
    @Override
    public User mapToUser(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(request.password());

        return user;
    }
}
