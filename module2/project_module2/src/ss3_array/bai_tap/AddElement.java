package ss3_array.bai_tap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
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

        System.out.print("\nEnter element you want to add: ");
        int addElement = input.nextInt();
        System.out.print("Enter index you want: ");
        int index = input.nextInt();
        if(index < 0 && index >= (array.length-1)){
            System.out.print("Can't replace element");
        }
        array = Arrays.copyOf(array, array.length +1);
        int temp;
        for(int j = index; j < array.length-1; j++) {
            for(int k=j+1; k<array.length; k++){
                temp = array[k];
                array[k] = array[j];
            }
        }
        array[index] = addElement;
        System.out.print("\nArray length: "+ array.length);
        System.out.print("\nArray after add element: ");
        for(int j= 0; j< array.length; j++){
            System.out.print(array[j] + "\t");
        }
    }
}
