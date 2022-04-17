package controller;

import java.util.Scanner;


public class Menu {
   public static void mainMenu(){
       Scanner input = new Scanner(System.in);
       boolean flag = true;

       do{
           System.out.println("Chuong trinh quan ly phuong tien giao thong\n" +
                   "----Chon chuc nang---\n" +
                   "1. Them moi phuong tien.\n" +
                   "2. Hien thi phuong tien\n" +
                   "3. Xoa phuong tien\n" +
                   "4. Tim kiem theo bien kiem soat\n" +
                   "5. Thoat");
           System.out.print("Hay chon chuc nang: ");
           int num = Integer.parseInt(input.nextLine());
           switch (num){
               case 1 -> {
                   System.out.println("Them moi phuong tien");
                   SubMenu.addVehicle();
               }
               case 2 -> {
                   System.out.println("Hien thi phuong tien");
                   SubMenu.displayVehicle();
               }
               case 3 -> {
                   System.out.println("Xoa phuong tien");
                   SubMenu.delVehicle();
               }

               case 4 -> {
                   System.out.println("Tim kiem theo bien kiem soat");
                   SubMenu.findVehicle();
               }
               default -> {
                   System.out.println("Ban da thoat");
                   flag= false;
               }
           }
       }while(flag);
   }
}
