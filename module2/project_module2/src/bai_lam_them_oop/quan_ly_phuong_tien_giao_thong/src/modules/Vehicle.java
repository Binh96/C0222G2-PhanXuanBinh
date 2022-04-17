package modules;

import java.util.Date;

public abstract class Vehicle {
    private String bks;
    private ProductBrand nameBrand;
    private int nsx;
    private String host;

    public Vehicle(){

    }

    public Vehicle(String bks, ProductBrand nameBrand, int nsx, String host){
        this.bks = bks;
        this.nameBrand = nameBrand;
        this.nsx = nsx;
        this.host = host;
    }

    public String getBks() {
        return bks;
    }

    public void setBks(String bks) {
        this.bks = bks;
    }

    public ProductBrand getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(ProductBrand nameBrand) {
        this.nameBrand = nameBrand;
    }

    public int getNsx() {
        return nsx;
    }

    public void setNsx(int nsx) {
        this.nsx = nsx;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "bks= " + bks +
                ", nameBrand= '" + nameBrand + '\'' +
                ", nsx= " + nsx +
                ", host= '" + host + '\'';
    }
}
