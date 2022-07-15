package com.pxb.dto;

import com.pxb.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class CustomerDto implements Validator {
    @NotNull
    private int id;

    @NotNull
    private CustomerType customerType;

    @NotEmpty
    @NotBlank
    @Size(min = 1, message = "Please enter name")
    private String name;

    @NotEmpty
    @NotBlank
    @Min(18)
    private String dateOfBirth;

    @NotNull
    private int gender;

    @NotEmpty
    @NotBlank
    @Size(min = 9, max = 9, message = "Id card available, try again")
    private String idCard;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(090|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$", message = "Number phone available, try again")
    private String phoneNumber;

    @NotEmpty
    @NotBlank
    @Email
    private String email;

    @NotEmpty
    @NotBlank
    private String address;

    @NotNull
    private int status;

    public CustomerDto() {
    }

    public CustomerDto(int id, CustomerType customerType, String name, String dateOfBirth,
                       int gender, String idCard, String phoneNumber, String email, String address, int status) {
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
    }

    public CustomerDto(CustomerType customerType, String name, String dateOfBirth, int gender,
                       String idCard, String phoneNumber, String email, String address, int status) {
        this.customerType = customerType;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.status = status;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
