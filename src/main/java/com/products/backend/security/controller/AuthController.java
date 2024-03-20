package com.products.backend.security.controller;

import com.products.backend.security.dto.request.LoginRequest;
import com.products.backend.security.dto.request.RegisterRequest;
import com.products.backend.security.dto.response.LoginResponse;
import com.products.backend.security.dto.response.RegisterResponse;
import com.products.backend.security.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
@Tag(name = "Autenticación")
public class AuthController {
    private final IAuthService authService;

    @Operation(description = "Autentica a un usuario. Autenticado: No. Body: LoginRequest.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(this.authService.login(request));
    }

    @Operation(description = "Crea un usuario y también lo autentica. Autenticado: No. Body: RegisterRequest.")
    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.authService.register(request));
    }
}
