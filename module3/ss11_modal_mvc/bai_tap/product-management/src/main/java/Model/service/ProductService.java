package Model.service;

import Model.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void create(Product product);
    void update(Integer id, Product product);
    void delete(Product product);
    Product detail(Integer id);
    Product searchId(int id);
    Product search(String name);
}
