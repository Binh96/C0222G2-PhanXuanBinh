package ss12_java_collection_framework.bai_tap.productmanager.services;

import ss12_java_collection_framework.bai_tap.productmanager.modules.Product;

public interface IProductMangerService<T>{
    void add();
    void edit(int id);
    void deleted(int id);
    void display();
    Product search(String name);
}
