package com.pxb.backendexam.service.impl;

import com.pxb.backendexam.model.Product;
import com.pxb.backendexam.repository.ProductRepository;
import com.pxb.backendexam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
