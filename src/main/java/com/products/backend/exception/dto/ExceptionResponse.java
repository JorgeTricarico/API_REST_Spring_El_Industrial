package com.products.backend.exception.dto;

import java.util.Map;

public record ExceptionResponse(
        int statusCode,
        String message,
        Map<String, String> detail
) {
}
