package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.modules;

public class Car extends Vehicle{
    private int seat;
    private String model;

    public Car(){

    }

    public Car(String bks, ProductBrand nameBrand, int nsx, String host, int seat, String model){
        super(bks, nameBrand, nsx, host);
        this.seat = seat;
        this.model = model;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car: "+super.toString()+"," +
                "seat= " + seat +
                ", model= '" + model + '\'';
    }
}
