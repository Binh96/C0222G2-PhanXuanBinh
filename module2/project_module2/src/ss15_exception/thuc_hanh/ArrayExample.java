package ss15_exception.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        ArrayExample arrayExample = new ArrayExample();
        Integer[] arr = arrayExample.createRandom();

        Scanner input = new Scanner(System.in);
        System.out.println("\nVui long nhap chi so cua mot phan tu bat ky: ");
        int x = input.nextInt();
        try{
            System.out.println("Gia tri phan tu co chi so 5 "+x+ "la " + arr[x]);
        }catch (IndexOutOfBoundsException e){
            System.err.println("Chi so vuot qua gioi han cua mang");
        }
    }

    public Integer[] createRandom(){
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Dan sach phan tu cua mang: ");
        for(int i=0; i<100; i++){
            arr[i] = rd.nextInt(100);
            System.out.println(arr[i] + " ");
        }
        return arr;
    }
}
