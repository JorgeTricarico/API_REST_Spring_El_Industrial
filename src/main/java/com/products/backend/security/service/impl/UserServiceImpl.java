package com.products.backend.security.service.impl;

import com.products.backend.security.domain.entity.User;
import com.products.backend.security.repository.IUserRepository;
import com.products.backend.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    @Transactional
    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }
}
