package com.products.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id; // Autogenerate
    private String name; // Scraping
    private String code; // Excel
    private String description; // Excel
    private Double price; // Excel
    private String urlProduct; // Scraping
    private List<String> urlImage; // Scraping
    private List<String> colorsStyle; // Scraping
    private List<String> colorsText; // Excel
    private String style; // Excel
    private String use; // Excel
    private Integer discount; // Autogenerate
    private Double priceVariation; // Autogenerate
    private Integer stock; // Autogenerate

    private boolean isDeleted; // Soft Delete
    private LocalDateTime createdAt; // Autogenerate
    private LocalDateTime updatedAt; // Autogenerate

    private String list; // Autogenerate
}
