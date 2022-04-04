package advanced_programming_with_java.bai_tap;

import java.util.Scanner;

public class revertMoney {
    public static void main(String[] args) {
        float tiGiaVnd = 23000;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap gia tien muon doi: ");

        double moneyUSD = scanner.nextDouble();
        double moneyVND = moneyUSD * tiGiaVnd;

        System.out.printf("Gia tien VND: " + moneyVND);

    }
}
