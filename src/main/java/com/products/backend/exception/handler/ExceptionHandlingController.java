package com.products.backend.exception.handler;

import com.products.backend.exception.EmailNotFoundException;
import com.products.backend.exception.dto.ExceptionResponse;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionHandlingController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse validException(MethodArgumentNotValidException ex){
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        Map<String, String> detail = new HashMap<>();

        errors.forEach(error -> detail.put(error.getField(), error.getDefaultMessage()));

        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), "Validaciones", detail);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleEmailNotFoundException(EmailNotFoundException ex) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), null);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ExceptionResponse handleUnauthorizedException(BadCredentialsException ex){
        return new ExceptionResponse(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handleAccessDeniedException(AccessDeniedException ex){
        return new ExceptionResponse(
                HttpStatus.FORBIDDEN.value(),
                "No tenes permisos para acceder a este recurso.",
                null
        );
    }

    @ExceptionHandler(MalformedJwtException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handleMalformedJwtException(MalformedJwtException ex){
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleInternalServerError(RuntimeException ex){
        Map<String, String> detail = new HashMap<>();
        detail.put("Clase", ex.getClass().getName());

        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(),
                detail
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponse handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        return new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error en la integridad de datos de la base de datos.",
                null
        );
    }
}
