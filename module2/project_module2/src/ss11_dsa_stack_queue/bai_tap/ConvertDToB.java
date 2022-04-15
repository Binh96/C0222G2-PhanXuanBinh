package ss11_dsa_stack_queue.bai_tap;

import java.util.Stack;

public class ConvertDToB{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int decimalNumber = 320;
        System.out.printf("Binary of %d is: ", decimalNumber);
        while(decimalNumber!=0){
            int temp = decimalNumber % 2;
            decimalNumber = decimalNumber /2;
            stack.push(temp);
        }
        for(int i=stack.size()-1; i>=0; i--){
            System.out.printf("%d", stack.get(i));
        }
    }
}
