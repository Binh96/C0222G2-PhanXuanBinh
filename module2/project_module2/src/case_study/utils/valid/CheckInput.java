package case_study.utils.valid;

import java.util.Scanner;

public class CheckInput {
    static Scanner sc = new Scanner(System.in);
    public static String stringInput(String input, String regex){
        boolean check = true;
        while(check){
            if(input.matches(regex)){
                check = false;
            }
            else{
                System.out.println(">>>>> Something goes wrong! please check input format.......");
                System.out.print("Enter again: ");
                input = sc.nextLine();
            }
        }
        return input;
    }
}
