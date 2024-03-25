package com.products.backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.Map;

@Data
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-generated

    private String code; // Excel

    private String description; // Excel

    private Double price; // Excel

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> characteristics = new HashMap<>();

    private Integer stock; // Auto-generated

    private Boolean isDeleted; // Soft Delete

    private LocalDateTime createdAt; // Auto-generated

    private LocalDateTime updatedAt; // Auto-generated

    public Product() {
        this.stock = 0;
        this.isDeleted = Boolean.FALSE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Product(String code, String description, Double price, Map<String,String> characteristics) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.characteristics= characteristics;
        this.stock = 0;
        this.isDeleted = Boolean.FALSE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    //    private String urlProduct; // Scraping
    //
    //    private List<String> urlImage; // Scraping
    //
    //    private List<String> colorsStyle; // Scraping
    //
    //    private List<String> colorsText; // Excel
    //
    //    private String style; // Excel
    //
    //    private String use; // Excel
    //
    //    private Integer discount; // Auto-generated
    //
    //    private Double priceVariation; // Auto-generated

    //    private ObjectMapper mapper = new ObjectMapper();

    // Getters and setters for additionalProperties
    // HashMap for dynamic characteristics
    //    @Getter
    //    @Setter
    //    private Map<String, String> additionalProperties = new HashMap<>();

}
