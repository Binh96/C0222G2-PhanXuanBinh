package ss3_array.bai_tap;

import java.util.Scanner;

public class ConcatenateArray {
    public static void main(String[] args){
        int size1;
        int size2;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of array one: ");
        size1= input.nextInt();
        System.out.print("\nEnter size of array two: ");
        size2= input.nextInt();

        int[] array1 = new int[size1];
        int[] array2 = new int[size2];

//        Nhap mang thu nhat
        System.out.print("Enter element of array one: ");
        for(int i=0; i<size1; i++){
            array1[i] = input.nextInt();
        }
        System.out.print("\nArray one: ");
        for(int i=0; i<size1; i++){
            System.out.print(array1[i]+"\t");
        }
//        Nhap mang thu hai
        System.out.print("\nEnter element of array two: ");
        for(int i=0; i<size2; i++){
            array2[i] = input.nextInt();
        }
        System.out.print("\nArray two: ");
        for(int i=0; i<size2; i++){
            System.out.print(array2[i]+"\t");
        }

        int[] array3 = new int[array1.length+array2.length];

//        Noi chuoi
        for(int i=0; i< array1.length; i++){
            array3[i] = array1[i];
        }
        for(int i=0; i<array2.length; i++){
            array3[array1.length+i] = array2[i];
        }
        System.out.print("Array after concatenate: ");
        for(int i=0; i < array3.length; i++){
            System.out.print("\t"+array3[i]);
        }
    }
}
