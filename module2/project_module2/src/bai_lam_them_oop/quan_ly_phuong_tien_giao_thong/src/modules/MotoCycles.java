package modules;

public class MotoCycles extends Vehicle{
    private int power;

    public MotoCycles(){

    }

    public MotoCycles(String bks, ProductBrand nameBrand, int nsx, String host, int power){
        super(bks, nameBrand, nsx, host);
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "MotoCycles: "+ super.toString() +
                ", power=" + power;
    }
}
