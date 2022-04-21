package ss11_dsa_stack_queue.bai_tap;

import java.util.*;

public class CountWordUseMap {
    public static void main(String[] args){
        TreeMap<Character, Integer> map=new TreeMap<>();
        String stringWord = "Phan xuan binh";
        stringWord = stringWord.toLowerCase();

        for(int i=0; i<stringWord.length(); i++){
            if(!map.containsKey(stringWord.charAt(i))){
                map.put(stringWord.charAt(i), 1);
            }
            else{
                map.put(stringWord.charAt(i), map.get(stringWord.charAt(i))+1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : "+ entry.getValue());
        }
    }
}
