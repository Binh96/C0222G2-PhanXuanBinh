package com.service;

import com.model.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(Long id);
}
