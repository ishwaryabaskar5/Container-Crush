package com.containercrush.unbeatable.product.repository;

import com.containercrush.unbeatable.product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer> {
}
