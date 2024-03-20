package com.products.backend.security.dto.response;

public record RegisterResponse(
        String username,
        String email,
        String token
) {
}
