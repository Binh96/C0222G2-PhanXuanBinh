package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_khach_hang")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_loai_khach_hang")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(int id, String customerTypeName, List<Customer> customers) {
        this.id = id;
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public CustomerType(String customerTypeName, List<Customer> customers) {
        this.customerTypeName = customerTypeName;
        this.customers = customers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
