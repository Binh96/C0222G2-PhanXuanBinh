package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.controller;

import java.util.Scanner;


public class MenuVehicle {

    private static SubMenuVehicle subMenuVehicle;

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
                   SubMenuVehicle.addVehicle();
               }
               case 2 -> {
                   System.out.println("Hien thi phuong tien");
                   SubMenuVehicle.displayVehicle();
               }
               case 3 -> {
                   System.out.println("Xoa phuong tien");
                   SubMenuVehicle.delVehicle();
               }

               case 4 -> {
                   System.out.println("Tim kiem theo bien kiem soat");
                   SubMenuVehicle.findVehicle();
               }
               default -> {
                   System.out.println("Ban da thoat");
                   flag= false;
               }
           }
       }while(flag);
   }

    public void displayMenu() {
    }
}
