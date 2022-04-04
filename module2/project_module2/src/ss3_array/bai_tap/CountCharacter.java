package ss3_array.bai_tap;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strings = "Phan Xuan Binh";

        System.out.print("Enter character you want to find: ");
        char character= input.nextLine().charAt(0);
        System.out.print("\ncharacter you want to find: "+ character);

        int count=0;
        for(int i=0; i< strings.length(); i++){
            if(character == strings.charAt(i)){
                count++;
            }
        }
        System.out.print("\nTimes character has in string: "+ count);
    }
}
