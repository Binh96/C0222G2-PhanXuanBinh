package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "gioi_tinh")
public class Gender {
    @Id
    private int id;

    @Column(name = "ten_gioi_tinh")
    private String nameGender;

    @OneToMany(mappedBy = "customerGender")
    private List<Customer> customers;

    public Gender() {
    }

    public Gender(int id, String nameGender, List<Customer> customers) {
        this.id = id;
        this.nameGender = nameGender;
        this.customers = customers;
    }

    public Gender(String nameGender, List<Customer> customers) {
        this.nameGender = nameGender;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
