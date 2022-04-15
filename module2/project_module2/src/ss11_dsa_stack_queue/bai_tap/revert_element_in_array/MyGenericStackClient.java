package ss11_dsa_stack_queue.bai_tap.revert_element_in_array;

import java.util.Arrays;

public class MyGenericStackClient {
    public static void main(String[] args) {
        int[] arr = {2,5,7,8,3};
        String string = "hniB m'I, olleH";

        System.out.println("Stack of integer: ");
        stackOfInteger(arr);

        String[] arrOfString = string.split("");
        System.out.println("\nStack of string: ");
        stackOfString(arrOfString);
    }

    public static void stackOfInteger(int[] arr){
        MyGenericStack<Integer> integerList = new MyGenericStack<>();

        for(int i: arr){
            integerList.push(i);
        }

        while (!integerList.isEmpty()){
            System.out.printf(" %d", integerList.pop());
        }

    }

    public static void stackOfString(String[] str){
        MyGenericStack<String> string = new MyGenericStack<>();

        for(String i : str){
            string.push(i);
        }

        while(!string.isEmpty()){
            System.out.printf("%s", string.pop());
        }

    }
}
