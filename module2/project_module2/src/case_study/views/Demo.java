package case_study.views;

import java.util.*;


import case_study.utils.valid.DateException;

import java.text.ParseException;

public class Demo {
    public static void main(String[] args) throws ParseException, DateException {
        int h = 10;
        for(int i=1; i<=h  ; i++){
            for(int j  = i; j <=h ; j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i*2 ; k++){
                if(k==1 || (k==(i*2-1)) || i==h){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }
        }

    }

}

