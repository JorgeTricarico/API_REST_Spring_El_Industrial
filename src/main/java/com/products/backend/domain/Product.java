package com.products.backend.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.HashMap;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="Products")
public class Product {
    //@MongoId
    @Id
    private String id; // Auto-generated

    //private String name; // Scraping
    @JsonProperty
    private String code; // Excel

    @JsonProperty
    private String description; // Excel

    @JsonProperty
    private Double price; // Excel

    @JsonProperty
    private Map<String, String> characteristics;

    @JsonProperty
    private Integer stock; // Auto-generated

    @JsonProperty
    private Boolean isDeleted; // Soft Delete

    @JsonProperty
    private LocalDateTime createdAt; // Auto-generated

    @JsonProperty
    private LocalDateTime updatedAt; // Auto-generated

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
