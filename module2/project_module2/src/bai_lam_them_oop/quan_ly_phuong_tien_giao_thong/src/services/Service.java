package bai_lam_them_oop.quan_ly_phuong_tien_giao_thong.src.services;

public interface Service {
    void add();
    void display();
    void del(String bks);
    boolean check(String bks);
    String search(String bks);
//    String searchBKS(int index);
}
