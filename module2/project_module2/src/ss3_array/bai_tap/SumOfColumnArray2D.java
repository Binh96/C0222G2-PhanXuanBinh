package ss3_array.bai_tap;

import java.util.Scanner;

public class SumOfColumnArray2D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size1 = input.nextInt();

        System.out.print("\nEnter size of column array: ");
        int size2 = input.nextInt();

        int[][] array = new int[size1][size2];
        //        Nhap mang
        for(int i=0; i< size1; i++){
            System.out.print("Enter element of array line "+ (i+1)+": ");
            for(int j=0; j< size2; j++){
                array[i][j]= input.nextInt();
            }
        }
//        Xuat mang
        System.out.print("Element of array: ");
        for(int i=0; i<size1; i++){
            System.out.print("[");
            for(int j=0; j<size2; j++){
                System.out.print(array[i][j]+", ");
            }
            System.out.print("]\n");
        }

        // Tinh tong column
        System.out.print("\nEnter column you want calculator: ");
        int column = input.nextInt();
        int sum=0;
        for(int i=0; i< size2; i++){
            sum += array[column][i];
        }
        System.out.print("\nResult: "+ sum);
    }
}
