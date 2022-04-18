package ss12_java_collection_framework.bai_tap.productmanager.services.impl;
import ss12_java_collection_framework.bai_tap.productmanager.modules.Product;
import ss12_java_collection_framework.bai_tap.productmanager.services.IProductMangerService;

import java.util.*;

public class ProductManagerService implements IProductMangerService {
    private static Scanner input = new Scanner(System.in);
    private static List<Product> products = new ArrayList<>();
    @Override
    public void add() {
        System.out.print("Nhap san pham: ");
        String product = input.nextLine();
        System.out.print("Nhap gia: ");
        int priceProduct = Integer.parseInt(input.nextLine());
        System.out.print("Nhap id: ");
        int idProduct = Integer.parseInt(input.nextLine());

        products.add(new Product(product, idProduct, priceProduct));
    }

    @Override
    public void edit(int index) {
        for (Product value : products) {
            if (value.getId() == index) {
                System.out.print("Nhap san pham: ");
                String product = input.nextLine();
                value.setName(product);
                System.out.print("Nhap gia: ");
                int priceProduct = Integer.parseInt(input.nextLine());
                value.setPrice(priceProduct);
                System.out.print("Nhap id: ");
                int idProduct = Integer.parseInt(input.nextLine());
                value.setId(idProduct);
                break;
            }
        }
    }

    @Override
    public void deleted(int id) {
        for(int i=0; i< products.size(); i++){
            if(products.get(i).getId() == id){
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public void display() {
        Collections.sort(products);
        for(Product product : products){
            System.out.println(product);
        }
    }

    @Override
    public Product search(String name) {
        for(Product product : products){
            if(product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }


}
