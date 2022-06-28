package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="ma_khach_hang")
    private String customerId;
    
    @ManyToOne
    @JoinColumn(name = "ma_loai_khach_hang", referencedColumnName = "id")
    private CustomerType customerType;

    @Column(name="ten_khach_hang")
    private String customerName;

    @Column(name="ngay_sinh", columnDefinition = "date")
    private Date customerBirthday;

    @ManyToOne
    @JoinColumn(name = "gioi_tinh", referencedColumnName = "id")
    private Gender customerGender;

    @Column(name= "cmnd")
    private String customerIdCard;

    @Column(name= "sdt")
    private String customerNumberPhone;

    @Column(name= "email")
    private String customerEmail;

    @Column(name="dia_chi")
    private String customerAddress;

    public Customer() {
    }

    public Customer(int id, String customerId, CustomerType customerType, String customerName,
                    Date customerBirthday, Gender customerGender, String customerIdCard,
                    String customerNumberPhone, String customerEmail, String customerAddress) {
        this.id = id;
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerNumberPhone = customerNumberPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Customer(String customerId, CustomerType customerType, String customerName,
                    Date customerBirthday, Gender customerGender, String customerIdCard,
                    String customerNumberPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerNumberPhone = customerNumberPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Gender getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Gender customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerNumberPhone() {
        return customerNumberPhone;
    }

    public void setCustomerNumberPhone(String customerNumberPhone) {
        this.customerNumberPhone = customerNumberPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
}
