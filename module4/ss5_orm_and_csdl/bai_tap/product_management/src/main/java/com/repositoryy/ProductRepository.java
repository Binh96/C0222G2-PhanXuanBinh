package com.repositoryy;

import com.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> selectAll();

    void createProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product selectOne(int id);

    List<Product> searchByName(String name);
}
