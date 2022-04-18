package ss12_java_collection_framework.bai_tap.productmanager.controller;

import ss12_java_collection_framework.bai_tap.productmanager.services.IProductMangerService;
import ss12_java_collection_framework.bai_tap.productmanager.services.impl.ProductManagerService;

import java.util.Scanner;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);

    private static IProductMangerService iProductMangerService = new ProductManagerService();

    public void hienThiMenu(){
        while(true){
            System.out.println("------Quan ly san pham--------");
            System.out.println("1. Them");
            System.out.println("2. Sua");
            System.out.println("3. Xoa");
            System.out.println("4. Hien thi");
            System.out.println("5. Tim san pham");
            System.out.print("Nhap so: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> {
                    iProductMangerService.add();
                }
                case 2 ->{
                    System.out.print("Nhap id san pham muon sua: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    iProductMangerService.edit(index);
                }
                case 3 -> {
                    System.out.print("Nhap id san pham ban muon xoa: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    iProductMangerService.deleted(index);
                }
                case 4 -> {
                    iProductMangerService.display();
                }
                case 5 -> {
                    System.out.print("Nhap san pham ban muon tim: ");
                    String name = scanner.nextLine();
                    System.out.println(iProductMangerService.search(name));
                }
                case 6 ->{
                    System.exit(0);
                }
            }
        }
    }
}
