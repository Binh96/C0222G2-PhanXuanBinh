package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.modules;

public class Trucks extends Vehicle{
    private double weight;

    public Trucks(){

    }

    public Trucks(String bks, ProductBrand nameBrand, int nsx, String host, double weight){
        super(bks, nameBrand, nsx, host);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Truck: "+ super.toString() +
                " weight=" + weight;
    }
}
