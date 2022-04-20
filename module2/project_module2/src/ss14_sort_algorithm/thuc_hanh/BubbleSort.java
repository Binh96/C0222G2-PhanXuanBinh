package ss14_sort_algorithm.thuc_hanh;

import java.util.Scanner;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }

    public static void bubbleSort(int[] list){
        for(int i=1; i<list.length; i++){
            for(int k=0; k<list.length-i; k++){
                if(list[k] > list[k+1]){
                    int temp = list[k];
                    list[k] = list[k+1];
                    list[k+1] = temp;
                }
            }
        }
    }
}
