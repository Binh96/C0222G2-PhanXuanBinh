package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services.impl;

import bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services.MotoCycleService;
import bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.modules.MotoCycles;

import java.util.ArrayList;
import java.util.Scanner;

public class MotoCycleImpl implements MotoCycleService {
    ArrayList<MotoCycles> motoCycles = new ArrayList<>();
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
        System.out.print("Cong suat: ");
        int power = Integer.parseInt(input.nextLine());

        motoCycles.add(new MotoCycles(bks, productBrandService.getProductBrand(productBrand), dateProduct, host, power));
    }

    @Override
    public void display() {
        for (MotoCycles bike : motoCycles) {
            System.out.println(bike);
        }
    }

    @Override
    public void del(String bks) {
        for (int i=0; i< motoCycles.size(); i++) {
            if (motoCycles.get(i).getBks().equals(bks)) {
                motoCycles.remove(i);
                break;
            }
        }
    }

    public boolean check(String bks){
        for (MotoCycles bike : motoCycles) {
            if (bike.getBks().equals(bks)) {
                return true;
            }
        }
        return false;
    }

    public String search(String bks){
        int count=0;
        for(int i = 0; i< motoCycles.size(); i++){
            if(motoCycles.get(i).getBks().equals(bks)){
                return motoCycles.get(i).toString();
            }
        }
        return null;
    }
}
