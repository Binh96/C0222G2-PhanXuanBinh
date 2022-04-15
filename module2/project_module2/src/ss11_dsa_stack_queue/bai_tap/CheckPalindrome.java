package ss11_dsa_stack_queue.bai_tap;


import java.util.*;

public class CheckPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter string you want to know it's palindrome or not: ");
        String string = input.nextLine();
        System.out.println("String is palindrome: " + isPalindrome(string.toLowerCase()));
    }

    public static boolean isPalindrome(String str){
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        String[] stringToArray = str.split("");

        for(String i : stringToArray){
            if(!Objects.equals(i, " ")){
                stack.push(i);
            }
        }

        for(String i : stringToArray){
            if(!Objects.equals(i, " ")){
                queue.add(i);
            }
        }

        boolean flag = true;

        while(!stack.empty()){
            if(!stack.pop().equals(queue.remove())){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
