package com.products.backend.security.service.impl;

import com.products.backend.exception.EmailNotFoundException;
import com.products.backend.security.config.SecurityConfig;
import com.products.backend.security.domain.UserDetailsImpl;
import com.products.backend.security.domain.entity.Role;
import com.products.backend.security.domain.entity.User;
import com.products.backend.security.domain.enums.RoleName;
import com.products.backend.security.dto.mapper.register.IRegisterMapper;
import com.products.backend.security.dto.request.LoginRequest;
import com.products.backend.security.dto.request.RegisterRequest;
import com.products.backend.security.dto.response.LoginResponse;
import com.products.backend.security.dto.response.RegisterResponse;
import com.products.backend.security.jwt.JwtTokenProvider;
import com.products.backend.security.service.IAuthService;
import com.products.backend.security.service.IRoleService;
import com.products.backend.security.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {
    private final AuthenticationManager authManager;
    private final IUserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final IRoleService roleService;
    private final IRegisterMapper registerMapper;

    @Override
    public LoginResponse login(LoginRequest request) {
        try {
            UserDetailsImpl userDetailsImpl = this.userDetailsServiceImpl.loadUserByUsername(request.email());
            this.authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

            String token = this.jwtTokenProvider.generateToken(userDetailsImpl);

            return new LoginResponse(userDetailsImpl.getUsername(), token);
        } catch (EmailNotFoundException ex) {
            throw new EmailNotFoundException(request.email());
        }
    }

    @Transactional
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = this.registerMapper.mapToUser(request);
        user.setPassword(SecurityConfig.passwordEncoder().encode(request.password()));

        Optional<Role> optionalRole = this.roleService.findByName(RoleName.USER.getName());
        optionalRole.ifPresent(user::setRole);

        this.userService.save(user);

        LoginRequest loginRequest = new LoginRequest(request.email(), request.password());

        LoginResponse loginResponse = this.login(loginRequest);

        return new RegisterResponse(request.username(), request.email(), loginResponse.token());
    }
}
