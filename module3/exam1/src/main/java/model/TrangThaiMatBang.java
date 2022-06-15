package model;

public class TrangThaiMatBang {
    private Integer maTrangThai;
    private String tenTrangThai;

    public TrangThaiMatBang() {
    }

    public TrangThaiMatBang(Integer maTrangThai, String tenTrangThai) {
        this.maTrangThai = maTrangThai;
        this.tenTrangThai = tenTrangThai;
    }

    public Integer getMaTrangThai() {
        return maTrangThai;
    }

    public void setMaTrangThai(Integer maTrangThai) {
        this.maTrangThai = maTrangThai;
    }

    public String getTenTrangThai() {
        return tenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
        this.tenTrangThai = tenTrangThai;
    }
}
