package services.impl;

import services.TruckService;
import modules.Trucks;
import java.util.ArrayList;
import java.util.Scanner;

public class TruckImpl implements TruckService {
    ArrayList<Trucks> Truck = new ArrayList<>();
    ProductBrandServiceImpl productBrandService = new ProductBrandServiceImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Bien kiem soat: ");
        String bks = input.nextLine();
        System.out.print("Hang san xuat: \n");
        productBrandService.display();
        System.out.print("Chon hang san xuat: ");
        int productBrand = Integer.parseInt(input.nextLine());
        System.out.println(productBrandService.getProductBrand(productBrand));
        System.out.print("Nam san xuat: ");
        int dateProduct = Integer.parseInt(input.nextLine());
        System.out.print("Chu so huu: ");
        String host = input.nextLine();
        System.out.print("Tai Trong: ");
        int weight = Integer.parseInt(input.nextLine());


        Truck.add(new Trucks(bks, productBrandService.getProductBrand(productBrand), dateProduct, host, weight));
    }

    @Override
    public void display() {
        for (Trucks truck : Truck) {
            System.out.println(truck);
        }
    }

    @Override
    public void del(String bks) {
        for (int i=0; i< Truck.size(); i++) {
            if (Truck.get(i).getBks().equals(bks)) {
                Truck.remove(i);
                break;
            }
        }
    }

    public boolean check(String bks){
        for (Trucks truck : Truck) {
            if (truck.getBks().equals(bks)) {
                return true;
            }
        }
        return false;
    }

    public String search(String bks){
        int count=0;
        for(int i = 0; i< Truck.size(); i++){
            if(Truck.get(i).getBks().equals(bks)){
                return Truck.get(i).toString();
            }
        }
        return null;
    }
}
