package services.impl;

import modules.MotoCycles;
import services.ProductBrandService;
import modules.ProductBrand;

import java.util.ArrayList;

public class ProductBrandServiceImpl implements ProductBrandService {
    static ArrayList<ProductBrand> productBrands = new ArrayList<>();
    static{
        productBrands.add(0, new ProductBrand("K232S", "BWM", "Germany"));
        productBrands.add(1, new ProductBrand("K232S", "Mercedes", "Germany"));
        productBrands.add(2, new ProductBrand("K232S", "Lexus", "USA"));
        productBrands.add(3, new ProductBrand("K232S", "VinFast", "VietNam"));
        productBrands.add(4, new ProductBrand("K232S", "Toyota", "Japan"));
    }

    public ProductBrand getProductBrand(int index){
        return productBrands.get(index);
    }

    @Override
    public void add() {

    }

    @Override
    public void display() {
       for(int i=0; i < productBrands.size(); i++){
           System.out.println("Option "+(i+1)+": "+ productBrands.get(i));
       }
    }

    @Override
    public void del(String bks) {

    }

    public boolean check(String bks){
        return false;
    }

    public String search(String bks){
        return null;
    }

//    @Override
//    public String searchBKS(int index) {
//
//    }
}
