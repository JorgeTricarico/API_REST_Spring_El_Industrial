package com.products.backend.controller;

import com.products.backend.repositories.database.IProductJpaRepository;
import com.products.backend.services.implemetantions.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServices productServices;

    @Autowired
    IProductJpaRepository repo;
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        String message = "Hello, World!";
        return ResponseEntity.ok(message);
    }
    @PostMapping("/")
    public ResponseEntity<String> save() { // @RequestBody Product product

        try {
            productServices.save();
            return ResponseEntity.ok("Producto guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el producto");
        }
    }

    @GetMapping("/")
    public ResponseEntity<String> findAllProduct() {
        String products = repo.findAll().toString();
        return ResponseEntity.ok().body(products);
    }
}
