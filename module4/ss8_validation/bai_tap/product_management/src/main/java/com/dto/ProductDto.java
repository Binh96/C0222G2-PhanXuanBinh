package com.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class ProductDto implements Validator {
    @NotNull
    private int id;

    @NotEmpty
    @NotBlank
    @Size(min = 2, max = 50)
    private String nameProduct;

    @Min(1)
    private Integer price;

    @NotEmpty
    @NotBlank
    private String descProduct;

    @NotEmpty
    @NotBlank
    private String producer;


    public ProductDto() {
    }

    public ProductDto(@NotNull @NotBlank int id, @NotEmpty @NotBlank @Size(min = 2, max = 50) String nameProduct,
                      @Min(1) Integer price, @NotEmpty @NotBlank String descProduct, @NotEmpty @NotBlank String producer) {
        this.id = id;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
