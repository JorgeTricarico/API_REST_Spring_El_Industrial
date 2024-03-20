package com.products.backend.security.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginRequest(
        @NotNull(message = "El email no puede ser nulo.")
        @Email(message = "Formato de email inválido.")
        @NotBlank(message = "El email no puede estar vacío.")
        String email,
        @NotNull(message = "La contraseña no puede ser nula.")
        @NotBlank(message = "La contraseña no puede estar vacía.")
        String password
) {
}
