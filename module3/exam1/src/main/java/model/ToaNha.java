package model;

public class ToaNha {
    private String maToaNha;
    private Integer haTang;
    private Double dienTich;
    private Integer soTang;
    private Integer loaiMatBang;
    private String desc;
    private Integer giaTien;
    private String ngayBatDau;
    private String ngayKetThuc;

    public ToaNha() {
    }

    public ToaNha(String maToaNha, Integer haTang, Double dienTich, Integer soTang,
                  Integer loaiMatBang, String desc, Integer giaTien, String ngayBatDau, String ngayKetThuc) {
        this.maToaNha = maToaNha;
        this.haTang = haTang;
        this.dienTich = dienTich;
        this.soTang = soTang;
        this.loaiMatBang = loaiMatBang;
        this.desc = desc;
        this.giaTien = giaTien;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaToaNha() {
        return maToaNha;
    }

    public void setMaToaNha(String maToaNha) {
        this.maToaNha = maToaNha;
    }

    public Integer getHaTang() {
        return haTang;
    }

    public void setHaTang(Integer haTang) {
        this.haTang = haTang;
    }

    public Double getDienTich() {
        return dienTich;
    }

    public void setDienTich(Double dienTich) {
        this.dienTich = dienTich;
    }

    public Integer getSoTang() {
        return soTang;
    }

    public void setSoTang(Integer soTang) {
        this.soTang = soTang;
    }

    public Integer getLoaiMatBang() {
        return loaiMatBang;
    }

    public void setLoaiMatBang(Integer loaiMatBang) {
        this.loaiMatBang = loaiMatBang;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Integer giaTien) {
        this.giaTien = giaTien;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }
}
