package ss11_dsa_stack_queue.bai_tap;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class CheckBracket {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = input.nextLine();
        String[] arrayExpression = expression.split("");

        System.out.println("Good Expression: " + checkBracket(arrayExpression));
    }

    public static boolean checkBracket(String[] arrayExpression){
        Stack<String> bracket = new Stack<>();
        String bracketClose = ")";
        String bracketOpen = "(";

        String left;

        for (String s : arrayExpression) {
            if(s.equals(bracketOpen)){
                bracket.push(s);
            }
            if(s.equals(bracketClose)){
                if(bracket.empty()){
                    return false;
                }
                left = bracket.pop();
                if(left.equals(s)){
                    return false;
                }
            }
        }
        return true;
    }

}
