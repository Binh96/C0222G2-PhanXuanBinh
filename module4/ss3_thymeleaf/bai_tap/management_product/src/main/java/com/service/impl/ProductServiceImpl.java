package com.service.impl;

import com.module.Product;
import com.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    private static List<Product> products = new ArrayList<>();

    static{
        products.add(new Product(123, "Iphone X", 2000, "new", "Apple"));
        products.add(new Product(321, "Nokia lumia", 100, "old", "Nokia"));
        products.add(new Product(322, "Red Magic", 800, "new", "Nubia"));
        products.add(new Product(564, "Sony Xperia", 1200, "new", "Sony"));
        products.add(new Product(678, "Note 8", 1000, "new", "Samsung"));
    }

    @Override
    public List<Product> selectAll() {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        for(int i =  0; i<products.size(); i++){
            if(id == products.get(i).getId()){
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for(int i =  0; i<products.size(); i++){
            if(id == products.get(i).getId()){
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public Product selectOne(int id) {
        for(Product p : products){
            if(id == p.getId()){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        for(Product p : products){
            if(p.getNameProduct().contains(name)){
                productList.add(p);
            }
        }
        return productList;
    }
}
