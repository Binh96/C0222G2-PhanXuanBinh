package ss11_dsa_stack_queue.bai_tap;

import java.util.Map;
import java.util.TreeMap;

public class CountWordUseMap {
    public static void main(String[] args){
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
        String stringWord = "Phan xuan binh";
        String[] splitString = stringWord.toLowerCase().split("");

        System.out.println("After split:");
        for(String i: splitString){
            System.out.print(i);
            map.put(1, i);
        }

        for(Object key: map.keySet()){
            System.out.println(key + " " + map.get(key));
        }
    }
}
