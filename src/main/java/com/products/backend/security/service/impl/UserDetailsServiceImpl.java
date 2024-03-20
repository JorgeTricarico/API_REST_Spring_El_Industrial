package com.products.backend.security.service.impl;

import com.products.backend.exception.EmailNotFoundException;
import com.products.backend.security.domain.UserDetailsImpl;
import com.products.backend.security.domain.entity.User;
import com.products.backend.security.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final IUserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(email).orElseThrow(() -> new EmailNotFoundException(email));

        return new UserDetailsImpl(user);
    }
}