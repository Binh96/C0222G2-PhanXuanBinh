package ss17_binary_file.bai_tap;

import java.io.Serializable;

public class Product implements Serializable {
    private int codeProduct;
    private String nameProduct;
    private String brandProduct;
    private int price;

    public Product(){

    }

    public Product(int codeProduct, String nameProduct, String brandProduct, int price){
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.brandProduct = brandProduct;
        this.price = price;
    }

    public int getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(int codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "codeProduct=" + codeProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", brandProduct='" + brandProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
