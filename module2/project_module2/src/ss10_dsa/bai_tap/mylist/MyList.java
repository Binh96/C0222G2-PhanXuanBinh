package ss10_dsa.bai_tap.mylist;

import java.util.Arrays;

public class MyList<E> {
    private int size =0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        elements = new Object[capacity];
    }

    public void add(int index, E element){
        ensureCapacity(size);
        for(int i = size - 1 ; i >= index; i--){
            elements[i+1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index){
        E e = (E) elements[index];

        for(int i=index; i < size - 1; i++){
            elements[i] = elements[i+1];
        }

//        elements[index - 1] = null;
        size--;
        return e;
    }

    public int size(){
        return  size;
    }

    public E clone(){
        Object[] newElements = Arrays.copyOf(elements, size);
        return (E) newElements;
    }

    public boolean contains(E o){
        for(int i = 0; i < size; i++){
            if(o.equals(elements[i])){
               return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for(int i = 0; i< size; i++){
            if(o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    public boolean add(E o){
        add(size(), o);
        return true;
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity >=0){
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public E get(int i){
        return (E) elements[i];
    }

    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size =0;
    }
}
