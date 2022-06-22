package com.controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int arr[] = {1,2,3,3};
        if(check(arr)){
            System.out.println("dep");
        }
        else{
            System.out.println("xau");
        }
    }

    public static boolean check(int[] arr){
        Scanner scanner = new Scanner(System.in);
        int finish = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int sum2= 0;

        for(int i=0; i<finish-1; i++){
            System.out.println(arr[i]);
            sum += arr[i];
        }
        for(int i=finish ; i< arr.length; i++){
            sum2 += arr[i];
        }
        System.out.println(sum);
        System.out.println(sum2);
        if(sum == sum2){
            return true;
        }
        return false;
    }
}
