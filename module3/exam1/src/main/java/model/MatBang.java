package model;

public class MatBang {
    private Integer maLoaiMatBang;
    private String tenLoaiMatBang;


    public MatBang() {
    }

    public MatBang(Integer maLoaiMatBang, String tenLoaiMatBang) {
        this.maLoaiMatBang = maLoaiMatBang;
        this.tenLoaiMatBang = tenLoaiMatBang;
    }

    public Integer getMaLoaiMatBang() {
        return maLoaiMatBang;
    }

    public void setMaLoaiMatBang(Integer maLoaiMatBang) {
        this.maLoaiMatBang = maLoaiMatBang;
    }

    public String getTenLoaiMatBang() {
        return tenLoaiMatBang;
    }

    public void setTenLoaiMatBang(String tenLoaiMatBang) {
        this.tenLoaiMatBang = tenLoaiMatBang;
    }
}
