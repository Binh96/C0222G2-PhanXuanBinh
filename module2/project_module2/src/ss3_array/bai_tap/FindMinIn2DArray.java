package ss3_array.bai_tap;

import java.util.Scanner;

public class FindMinIn2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sizeOfArray;
        System.out.print("Enter size of array dad: ");
        sizeOfArray = input.nextInt();

        int sizeOfArraySon;
        System.out.print("\nEnter size of array son: ");
        sizeOfArraySon = input.nextInt();

        float[][] array = new float[sizeOfArray][sizeOfArraySon];

//          Nhap mang
        for(int i=0; i<sizeOfArray; i++){
            System.out.print("\nEnter element of line "+(i+1)+": ");
            for(int j=0; j<sizeOfArraySon; j++){
                array[i][j] = input.nextFloat();
            }
        }
//            In mang
        System.out.print("Element of array: ");
        for(int i=0; i<sizeOfArray; i++){
            System.out.print("[");
            for(int j=0; j<sizeOfArraySon; j++){
                System.out.print(array[i][j]+", ");
            }
            System.out.print("]\n");
        }

        //    Tim phan tu nho nhat

        float min = array[0][0];
        int index;
        for(int i=1; i<sizeOfArray; i++){
            for(int j=1; j<sizeOfArraySon; j++){
                if(min > array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        System.out.print("Min element of array: "+ min);
    }
}
