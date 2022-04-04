package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class primeNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Số lượng số nguyên tố cần in");
        int numbers = input.nextInt();
        int count = 0;
        int n = 2;

        while(count<numbers){
            boolean flag = true;
            for(int i = 2; i< n; i++){
                if(n%i == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.printf("%d\t", n);
                count++;
            }
            n++;
        }

    }
}
