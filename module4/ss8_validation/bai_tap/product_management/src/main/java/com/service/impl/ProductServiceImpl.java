package com.service.impl;

import com.model.Product;
import com.repositoryy.ProductRepository;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> selectAll() {
        return productRepository.selectAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product selectOne(int id) {
        return productRepository.selectOne(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productRepository.selectByName(name);
    }
}
