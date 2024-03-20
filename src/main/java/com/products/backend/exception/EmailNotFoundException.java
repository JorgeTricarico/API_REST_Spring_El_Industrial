package com.products.backend.exception;

public class EmailNotFoundException extends RuntimeException {
    public static final String MESSAGE_TEXT = "No existe usuario con email: ";
    public EmailNotFoundException(String email) {
        super(MESSAGE_TEXT + email);
    }
}
