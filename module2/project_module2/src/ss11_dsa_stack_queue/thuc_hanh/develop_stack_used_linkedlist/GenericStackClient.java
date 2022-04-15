package ss11_dsa_stack_queue.thuc_hanh.develop_stack_used_linkedlist;

public class GenericStackClient {
    private static void stackOfStrings(){
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("1.1 Size of stack after push operation: "+ stack.size());
        System.out.println("1.2 Pop element from stack: ");
        while(!stack.isEmpty()){
            System.out.printf("%s ", stack.pop());
        }
        System.out.println("\n1.3 Size of stack after pop operation: "+ stack.size());
    }

    private static void stackOfInteger(){
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println("2.1. Size of stack after push operations: " + stack.size());
        System.out.print("2.2. Pop elements from stack : ");
        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }
        System.out.println("\n3.3 Size of stack after pop operations : " + stack.size());
    }

    public static void main(String[] args) {
        System.out.println("1. Stack of string");
        stackOfStrings();
        System.out.println("2. Stack of integer");
        stackOfInteger();
    }
}
