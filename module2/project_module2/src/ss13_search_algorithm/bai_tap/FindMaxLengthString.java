package ss13_search_algorithm.bai_tap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class FindMaxLengthString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String sentence = input.nextLine();

        LinkedList<Character> max = new LinkedList<Character>();

        for(int i=0; i<sentence.length(); i++){
            LinkedList<Character> list = new LinkedList<>();
            list.add(sentence.charAt(i));
            for(int j = i+1; j<sentence.length(); j++){
                if(sentence.charAt(j) > list.getLast()){
                    list.add(sentence.charAt(j));
                }
            }
            if(list.size() > max.size()){
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        for(Character i:max){
            System.out.print( i);
        }
    }
}
