package com.products.backend.repositories.database;

import com.products.backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductJpaRepository extends JpaRepository<Product,Long> {
    Optional<Product> findByNameIgnoreCase(String name);
    Optional<Product> findByCodeIgnoreCase(String code);

}