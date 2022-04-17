package modules;

import java.util.ArrayList;

public class ProductBrand {
    private String qrCode;
    private String nameBrand;
    private String nation;

    public ProductBrand(){

    }

    public ProductBrand(String qrCode, String nameBrand, String nation){
        this.qrCode = qrCode;
        this.nameBrand = nameBrand;
        this.nation = nation;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    @Override
    public String toString() {
        return "ProductBrand: " +
                "qrCode= " + qrCode +
                ", nameBrand= '" + nameBrand + '\'' +
                ", nation= '" + nation + '\'';
    }
}
