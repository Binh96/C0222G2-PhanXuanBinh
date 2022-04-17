package services.impl;

import services.CarService;
import modules.Car;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CarServiceImpl implements CarService {
    ArrayList<Car> Car = new ArrayList<>();
    ProductBrandServiceImpl productBrandService = new ProductBrandServiceImpl();
    Scanner input = new Scanner(System.in);

    @Override
    public void add(){
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
        System.out.print("Kieu xe: ");
        String model = input.nextLine();
        System.out.print("So cho ngoi: ");
        int seat = Integer.parseInt(input.nextLine());

        Car.add(new Car(bks, productBrandService.getProductBrand(productBrand), dateProduct, host, seat, model));
    }

    @Override
    public void display() {
        for (Car car : Car) {
            System.out.println(car);
        }
    }

    @Override
    public void del(String bks) {
        for (int i=0; i< Car.size(); i++) {
            if (Car.get(i).getBks().equals(bks)) {
                Car.remove(i);
                break;
            }
        }
    }

    public boolean check(String bks){
        for (Car car : Car) {
            if (car.getBks().equals(bks)) {
                return true;
            }
        }
        return false;
    }


    public String search(String bks){
        boolean flag=true;
        for(int i = 0; i< Car.size(); i++){
            int count=0;
            for(int j=0; j<bks.length(); j++){
                if(Car.get(i).getBks().charAt(j) == bks.charAt(j)){
                    count++;
                }
                else{
                    flag = false;
                    break;
                }
            }
            if(flag){
                return Car.get(i).toString();
            }
            else if(count>=2){
                return Car.get(i).toString();
            }
        }
        return "not found";
    }
}
