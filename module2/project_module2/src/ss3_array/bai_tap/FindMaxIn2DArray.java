package ss3_array.bai_tap;

import java.util.Scanner;

public class FindMaxIn2DArray {
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

        //    Tim phan tu lon nhat

        float max = array[0][0];
//        int index = 0;
//        int index2 = 0;
        for(int i=0; i<sizeOfArray; i++){
            for(int j=0; j<sizeOfArraySon; j++){
                if(max < array[i][j]) {
                    max = array[i][j];
//                    index = i;
//                    index2 = j;
                }
            }
        }
        System.out.print("Max element of array: "+ max);
    }
}
