package model;

public class Product {
    private Integer id;
    private String name;
    private Double price;
    private String desc;
    private String brand;

    public Product(){

    }

    public Product(Integer id, String name, Double price, String desc, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
