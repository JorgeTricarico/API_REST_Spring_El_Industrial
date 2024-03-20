package com.products.backend.security.service;

import com.products.backend.security.dto.request.LoginRequest;
import com.products.backend.security.dto.request.RegisterRequest;
import com.products.backend.security.dto.response.LoginResponse;
import com.products.backend.security.dto.response.RegisterResponse;

public interface IAuthService {
    LoginResponse login(LoginRequest request);
    RegisterResponse register(RegisterRequest request);
}
