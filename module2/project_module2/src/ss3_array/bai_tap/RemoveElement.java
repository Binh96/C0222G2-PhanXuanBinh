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
        for (int k : array) {
            System.out.print(k + "\t");
        }
            // Xóa phần tử
        System.out.print("\nEnter element you want to remove: ");
        int delElement = input.nextInt();
        int index = 0;
        boolean check = false;
        for(int j = 0; j < array.length; j++){
            if(delElement == array[j]){
                index = j;
                check = true;
            }
        }

        if(check){
            for(int j = index; j < array.length-1; j++){
                array[j] = array[j + 1];
            }
            System.out.print("Array after remove element: ");

            for(int j= 0; j< array.length-1; j++){
                System.out.print(array[j] + "\t");
            }
        }
        else{
            System.out.print("Element doesn't exist");
        }

    }

}
