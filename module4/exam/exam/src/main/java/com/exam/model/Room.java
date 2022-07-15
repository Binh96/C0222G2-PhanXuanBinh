package com.exam.model;

import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "phong_tro")
public class Room {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "dien_tich")
    private int area;

    @Column(name = "gia_thue")
    private int price;

    @Column(name = "tinh_trang_thue", columnDefinition = "int default 0")
    private int status;

    @OneToOne(mappedBy = "room")
    private Contract contracts;

    public Room() {
    }

    public Room(int id, int area, int price, int status, Contract contracts) {
        this.id = id;
        this.area = area;
        this.price = price;
        this.status = status;
        this.contracts = contracts;
    }

    public Room(int area, int price, int status, Contract contracts) {
        this.area = area;
        this.price = price;
        this.status = status;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Contract getContracts() {
        return contracts;
    }

    public void setContracts(Contract contracts) {
        this.contracts = contracts;
    }
}
