package ss12_java_collection_framework.bai_tap.productmanager.modules;

public class Product implements Comparable<Product> {
    private Integer id;
    private Integer price;
    private String name;

    public Product(){

    }

    public Product(String name, Integer id, Integer price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product: " +
                "id= " + id +
                ", price= " + price +
                ", name= '" + name + '\'';
    }

    @Override
    public int compareTo(Product o) {
        return this.getPrice().compareTo(o.getPrice());
    }
}
