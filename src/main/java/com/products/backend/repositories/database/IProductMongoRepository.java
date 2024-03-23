package com.products.backend.repositories.database;

import com.products.backend.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductMongoRepository extends MongoRepository<Product, String> {
    public Optional<Product> findByCode(String code);
    public void deleteById(Integer id);
}
