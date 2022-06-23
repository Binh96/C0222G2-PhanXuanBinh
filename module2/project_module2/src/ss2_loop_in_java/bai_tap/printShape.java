package ss2_loop_in_java.bai_tap;

import java.util.Scanner;

public class printShape {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//
//        int choice = -1;
//
//        while(choice != 0){
//            System.out.println("1. Print the rectangle");
//            System.out.println("2. Print the square triangle");
//            System.out.println("3. Print isosceles triangle");
//            System.out.println("4. Exit");
//            System.out.println("Enter your choice: ");
//            choice = input.nextInt();
//            switch (choice){
//                case 1 -> rectangle();
//                case 2 -> squareTriangle();
//                case 3 -> isoscelesTriangle();
//                case 4 -> System.exit(0);
//                default -> System.out.println("No choice!");
//            }
//        }
        String str = "abcbdcef";
        check(str);
    }

    public static void check(String string){
        String[] arr = string.split("");
        System.out.println(arr.toString());
    }
//
//    public static void rectangle(){
//        int h = 5;
//        int w = 8;
//
//        for(int i = 0; i < h; i++){
//            for(int j = 0; j < w; j++){
//                System.out.print("*\t");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void squareTriangle(){
//        int h = 7;
//
//        for(int i = 1; i <= h; i++){
//            for(int j = 1; j<=i; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
//
//    public static void isoscelesTriangle(){
//        int h = 5;
//
//        for(int i=h; i>0; i--){
//            for(int j=0; j<i ;j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
}
