package services;

public interface Service {
    void add();
    void display();
    void del(String bks);
    boolean check(String bks);
    String search(String bks);
//    String searchBKS(int index);
}
