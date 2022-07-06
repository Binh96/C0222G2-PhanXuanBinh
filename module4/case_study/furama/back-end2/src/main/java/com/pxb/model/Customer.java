package com.pxb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "loai_khach_hang", referencedColumnName = "id")
    private CustomerType customerType;

    @Column(name = "ten_khach_hang")
    private String name;

    @Column(name = "ngay_sinh", columnDefinition = "date")
    private String dateOfBirth;

    @Column(name = "gioi_tinh", columnDefinition = "bit")
    private int gender;

    @Column(name = "cmnd")
    private String idCard;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String address;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    public Customer() {
    }

    public Customer(int id, CustomerType customerType, String name, String dateOfBirth,
                    int gender, String idCard, String phoneNumber, String email, String address,
                    int status, List<Contract> contracts) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.contracts = contracts;
    }

    public Customer(CustomerType customerType, String name, String dateOfBirth,
                    int gender, String idCard, String phoneNumber, String email,
                    String address, int status, List<Contract> contracts) {
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
