package com.service;

import com.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> selectAll();

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int id);

    Product selectOne(int id);

    List<Product> searchByName(String name);
}
