package ss3_array.bai_tap;

import java.util.Scanner;

public class CalculatorMainDiagonalLine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size1 = input.nextInt();

        System.out.print("\nEnter size of column array: ");
        int size2 = input.nextInt();
        while(size1!=size2){
            System.out.print("\nNot square matrix, please retype");
            System.out.print("\nEnter size of array: ");
            size1 = input.nextInt();
            System.out.print("\nEnter size of column array: ");
            size2 = input.nextInt();
        }

        int[][] array = new int[size1][size2];
        //        Nhap mang
        for(int i=0; i< size1; i++){
            System.out.print("\nEnter element of array line "+ (i+1)+": ");
            for(int j=0; j< size2; j++){
                array[i][j]= input.nextInt();
            }
        }
//        Xuat mang
        System.out.print("Element of array: ");
        for(int i=0; i<size1; i++){
            System.out.print("[");
            for(int j=0; j<size2; j++){
                System.out.print(array[i][j]+" ");
            }
            System.out.print("]\n");
        }
//        In đường chéo thứ nhất
        int sum = 0;
        System.out.print("First main diagonal line: ");
        for(int i=0; i<size1; i++){
            System.out.print(array[i][i]+" ");
            sum+=array[i][i];
        }
        System.out.print("\nSum of first main diagonal line: "+ sum);

        // In đường chéo thứ hai
        int sum2 = 0;
        System.out.print("\nSecond main diagonal line: ");
        for(int i=0; i<size1; i++){
            System.out.print(array[i][size2-1-i]+" ");
            sum2+=array[i][size2-1-i];
        }
        System.out.print("\nSum of second main diagonal line: "+ sum2);
    }
}
