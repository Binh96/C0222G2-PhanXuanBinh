package ss14_sort_algorithm.thuc_hanh;

import java.util.Scanner;

public class BubbleSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " value: ");
        for(int i=0; i< list.length; i++){
            list[i] = scanner.nextInt();
        }
        System.out.println("Your input list: ");
        for(int i=0; i< list.length; i++){
            System.out.print(list[i] + "\t" );
        }

        System.out.println("\nBegin sort processing...");
        bubbleSortByStep(list);
    }

    public static void bubbleSortByStep(int[] list){
        boolean needNextPass = true;
        for(int i=1; i<list.length && needNextPass; i++){
            needNextPass = false;
            for(int k=0; k<list.length-i; k++){
                if(list[k] > list[k+1]){
                    System.out.println("swap " + list[k] + " with "+ list[i+1]);
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i+1] = temp;
                    needNextPass = true;
                }
            }
            if(!needNextPass){
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }
            System.out.print("List after the  " + i + "' sort: ");
            for (int j=0; j<list.length; j++){
                System.out.print(list[j] +"\t");
            }
            System.out.println();
        }
    }
}
