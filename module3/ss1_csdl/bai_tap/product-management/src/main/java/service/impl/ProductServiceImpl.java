package service.impl;

import model.Product;
import model.repository.ProductRepository;
import model.service.IProductRepository;
import service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private IProductRepository iProductService = new ProductRepository();

    @Override
    public List<Product> findAll() {
        return iProductService.getAll();
    }

    @Override
    public void create(Product product) {
        iProductService.save(product);
    }

    @Override
    public void update(Integer id, Product product) {
        iProductService.update(id, product);
    }

    @Override
    public void delete(Product product) {
        iProductService.remove(product.getId());
    }

    @Override
    public Product detail(Integer id) {
        return iProductService.search(id);
    }

    @Override
    public Product searchId(int id) {
        return iProductService.search(id);
    }

    @Override
    public Product search(String name) {
        return iProductService.searchName(name);
    }
}
