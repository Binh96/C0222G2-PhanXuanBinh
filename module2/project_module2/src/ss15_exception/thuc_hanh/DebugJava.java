package ss15_exception.thuc_hanh;

import java.util.Scanner;

public class DebugJava {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("a: ");
        double a = Double.parseDouble(input.nextLine());
        System.out.print("b: ");
        double b = Double.parseDouble(input.nextLine());

        if(a != 0){
            double result = -b/a;
            System.out.printf("The result is %f! ", result);
        }
        else{
            if(b==0){
                System.out.println("The result is all x!");
            }
            else{
                System.out.println("No result!");
            }
        }
    }
}
