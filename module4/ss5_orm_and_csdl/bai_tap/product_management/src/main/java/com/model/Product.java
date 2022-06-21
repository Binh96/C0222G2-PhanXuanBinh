package com.model;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_product")
    private String nameProduct;

    private Integer price;

    @Column(name = "desc_product")
    private String descProduct;
    private String producer;

    public Product() {
    }

    public Product(int id, String nameProduct, Integer price, String descProduct, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.descProduct = descProduct;
        this.producer = producer;
    }

    public Product(String nameProduct, Integer price, String descProduct, String producer) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.descProduct = descProduct;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescProduct() {
        return descProduct;
    }

    public void setDescProduct(String descProduct) {
        this.descProduct = descProduct;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
