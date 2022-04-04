package ss2_loop_in_java.thuc_hanh;

import java.util.Scanner;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        int choice = -1;
        Scanner input = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Draw the triangle");
        System.out.println("2. Draw the square");
        System.out.println("3. Draw the rectangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        choice = input.nextInt();
        switch (choice){
            case 1 -> triangle();
            case 2 -> square();
            case 3 -> rectangel();
            case 0 -> System.exit(0);
            default -> System.out.println("No choice!");
        }
    }

    public static void triangle(){
        int h = 5;

        for(int i=0; i<h; i++){
            for(int j=0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void square(){
        int h =6;
        int w = 6;

        for(int i=0; i<w; i++){
            for(int j=0; j<h; j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    public static void rectangel(){
        int h = 4;
        int w = 7;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }
}
