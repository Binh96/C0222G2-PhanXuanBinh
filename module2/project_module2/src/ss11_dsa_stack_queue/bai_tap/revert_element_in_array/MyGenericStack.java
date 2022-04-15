package ss11_dsa_stack_queue.bai_tap.revert_element_in_array;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> stack;

    public MyGenericStack(){
        stack = new LinkedList<>();
    }

    public void push(T element){
        stack.addFirst(element);
    }

    public T pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public boolean isEmpty(){
        return stack.size() == 0;
    }
}
