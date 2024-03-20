package com.products.backend.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Tag(name = "Test")
public class TestController {

    @Operation(description = "Endpoint de prueba. Los métodos GET se consumen sin necesidad de estar autenticado.")
    @GetMapping
    public ResponseEntity<Map<String, String>> testGet(){
        Map<String, String> map = new HashMap<>();
        map.put("test", "TEST GET");
        return ResponseEntity.ok(map);
    }

    @Operation(description = "Endpoint de prueba. Autenticado: Sí. Rol: Cualquiera. Body: Ninguno.")
    @PostMapping
    public ResponseEntity<Map<String, String>> testPost(){
        Map<String, String> map = new HashMap<>();
        map.put("test", "TEST POST");
        return ResponseEntity.ok(map);
    }
}
