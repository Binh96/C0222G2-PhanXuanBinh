package ss3_array.bai_tap;

import java.util.Scanner;

public class RemoveElement {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] array;
        int size;
        do{
            System.out.print("Enter array length: ");
            size =  input.nextInt();
            if(size > 20){
                System.out.println("Size does not exceed 20");
            }
        }while(size > 20);

        array = new int[size];

        int i = 0;

        while(i < array.length){
            System.out.print("Enter element "+ (i + 1) + ": ");
            array[i] = input.nextInt();
            i++;
        }

        System.out.print("Element of array: ");
        for(int j=0; j< array.length; j++){
            System.out.print(array[j]+ "\t");
        }

        System.out.print("Enter element you want to remove: ");
        int delElement = input.nextInt();
        int index = 0;
        for(int j = 0; j < array.length; j++){
            if(delElement == array[j]){
                index = j;
            }
        }

        for(int j = index; j < array.length-1; j++){
            array[j] = array[j + 1];
        }
        System.out.print("Array after remove element: ");

        for(int j= 0; j< array.length-1; j++){
            System.out.print(array[j] + "\t");
        }
    }

}
