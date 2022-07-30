package com.pxb.backendexam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lo_hang")
public class Consignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_lo_hang")
    private String codeConsignment;

    @ManyToOne
    @JoinColumn(name = "san_pham", referencedColumnName = "id")
    private Product product;

    @Column(name = "so_luong", columnDefinition = "int")
    private int quantity;

    @Column(name = "ngay_nhap_hang", columnDefinition = "date")
    private String dateIn;

    @Column(name = "ngay_xuat_hang", columnDefinition = "date")
    private String dateOut;

    @Column(name = "ngay_het_hang", columnDefinition = "date")
    private String endOfDate;

    public Consignment() {
    }

    public Consignment(int id, String codeConsignment, Product product, int quantity, String dateIn, String dateOut, String endOfDate) {
        this.id = id;
        this.codeConsignment = codeConsignment;
        this.product = product;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.endOfDate = endOfDate;
    }

    public Consignment(String codeConsignment, Product product, int quantity, String dateIn, String dateOut, String endOfDate) {
        this.codeConsignment = codeConsignment;
        this.product = product;
        this.quantity = quantity;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.endOfDate = endOfDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeConsignment() {
        return codeConsignment;
    }

    public void setCodeConsignment(String codeConsignment) {
        this.codeConsignment = codeConsignment;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getEndOfDate() {
        return endOfDate;
    }

    public void setEndOfDate(String endOfDate) {
        this.endOfDate = endOfDate;
    }
}
