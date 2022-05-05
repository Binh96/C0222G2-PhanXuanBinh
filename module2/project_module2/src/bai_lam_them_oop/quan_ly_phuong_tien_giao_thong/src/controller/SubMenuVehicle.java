package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.controller;


import bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services.impl.CarServiceImpl;
import bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services.impl.MotoCycleImpl;
import bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services.impl.TruckImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class SubMenuVehicle {
    static Scanner input = new Scanner(System.in);
    static CarServiceImpl carService = new CarServiceImpl();
    static MotoCycleImpl motoCycleService = new MotoCycleImpl();
    static TruckImpl truckService = new TruckImpl();
    public static void addVehicle(){
        boolean flag = true;

        do{
            System.out.println("""
                1. Them xe tai
                2. Them oto
                3. Them xe may
                """);
            System.out.print("Chon phuong tien muon them: ");
            int num = Integer.parseInt(input.nextLine());
            switch (num){
                case 1 -> {
                    System.out.println("Them phuong tien xe tai");
                    truckService.add();
                }
                case 2 -> {
                    System.out.println("Them phuong tien oto");
                    carService.add();
                }
                case 3 -> {
                    System.out.println("Them phuong tien xe may");
                    motoCycleService.add();
                }
                default -> {
                    System.out.println("Ban chon thoat");
                    flag= false;
                }
            }
        }while(flag);
    }

    public static void displayVehicle(){
        boolean flag = true;

        do{
            System.out.println("""
                1. Hien thi xe tai
                2. Hien thi oto
                3. Hien thi xe may
                """);
            System.out.print("Chon phuong tien muon hien thi: ");
            int num = Integer.parseInt(input.nextLine());
            switch (num){
                case 1 -> {
                    System.out.println("Hien thi phuong tien xe tai");
                    truckService.display();
                }
                case 2 -> {
                    System.out.println("Hien thi phuong tien oto");
                    carService.display();
                }
                case 3 -> {
                    System.out.println("Hien thi phuong tien xe may");
                    motoCycleService.display();
                }
                default -> {
                    System.out.println("Ban chon thoat");
                    flag= false;
                }
            }
        }while(flag);
    }

    public static void delVehicle(){
        System.out.print("Vui long nhap bien kiem soat: ");
        String bks = input.nextLine();
        String temp;
        if(carService.check(bks) || motoCycleService.check(bks) || truckService.check(bks)){
            System.out.println("Ban co muon xoa: ");
            System.out.print("Yes/No: ");
            String confirm = input.nextLine();
            switch (confirm){
                case "yes" -> {
                    if(carService.check(bks)){
                        carService.del(bks);
                    }
                    if(motoCycleService.check(bks)){
                        motoCycleService.del(bks);
                    }
                    if(truckService.check(bks)){
                        truckService.del(bks);
                    }
                    System.out.println("Ban da xoa thanh cong");
                }
                default -> {
                    System.out.println("Ban da huy xoa.");
                    System.out.println("Thoat");
                }
            }
        }
        else{
            System.out.println("Khong ton tai phuong tien ban muon xoa!");
        }
    }

    public static void findVehicle(){
        System.out.print("Nhap bien kiem soat: ");
        String bks = input.nextLine().toUpperCase();

        ArrayList<String> listBksHasFound = new ArrayList<>();

        if(carService.search(bks).equals("not found")){
            System.out.println("Khong tim thay phuong tien");
        }
        else{
            listBksHasFound.add(carService.search(bks));
        }

        System.out.println(listBksHasFound);
    }
}
