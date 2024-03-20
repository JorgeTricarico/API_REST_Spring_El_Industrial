package com.products.backend.security.dto.response;

public record LoginResponse(
        String email,
        String token
) {
}
