package ss17_binary_file.bai_tap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static ss17_binary_file.bai_tap.ReadAndWrite.readFile;
import static ss17_binary_file.bai_tap.ReadAndWrite.writeFile;

public class ProductMain {
    static Scanner input = new Scanner(System.in);
    static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(123, "Keo", "CSC", 2000));
        products.add(new Product(124, "Son", "VAV", 3000));
        products.add(new Product(125, "Banh", "ADA", 7000));
        products.add(new Product(126, "Sua", "QEQ", 5000));
    }
    public static void main(String[] args) {
        display();
        System.out.print("You want search some product: ");
        String name = input.nextLine();
        search(name);
        System.out.println("You want add some product:");
        add();
        display();
    }

    public static void display(){
        writeFile("product.txt", products);
        List<Product> productsDataReadFile = readFile("product.txt");
        for(Product p : productsDataReadFile){
            System.out.println(p);
        }
    }

    public static void add(){
        System.out.println("Enter code product: ");
        int codeProduct = Integer.parseInt(input.nextLine());
        System.out.print("Enter name product: ");
        String nameProduct = input.nextLine();
        System.out.print("Enter brand product: ");
        String brandProduct = input.nextLine();
        System.out.print("Enter price: ");
        int price = Integer.parseInt(input.nextLine());

        products.add(new Product(codeProduct, nameProduct, brandProduct, price));
    }

    public static Product search(String product){
        for (Product value : products) {
            if (value.getNameProduct().equals(product)) {
                return value;
            }
        }
        return null;
    }
}
