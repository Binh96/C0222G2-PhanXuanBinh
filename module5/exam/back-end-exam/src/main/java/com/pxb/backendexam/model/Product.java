package com.pxb.backendexam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "san_pham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_san_pham")
    private String nameProduct;

    @Column(name = "gia")
    private String price;

    @Column(name = "don_vi")
    private String unit;

    @Column(name = "xuat_xu")
    private String madIn;

    @OneToMany(mappedBy = "product")
    @JsonBackReference
    private List<Consignment> consignment;

    public Product() {
    }

    public Product(int id, String nameProduct, String price, String unit, String madIn, List<Consignment> consignment) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.unit = unit;
        this.madIn = madIn;
        this.consignment = consignment;
    }

    public Product(String nameProduct, String price, String unit, String madIn, List<Consignment> consignment) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.unit = unit;
        this.madIn = madIn;
        this.consignment = consignment;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMadIn() {
        return madIn;
    }

    public void setMadIn(String madIn) {
        this.madIn = madIn;
    }

    public List<Consignment> getConsignment() {
        return consignment;
    }

    public void setConsignment(List<Consignment> consignment) {
        this.consignment = consignment;
    }
}
