package ss4_class_and_object_in_java.bai_tap;


import java.util.Arrays;

public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch  stopWatch = new StopWatch();
        int[] array = new int[10000];
        for(int i=0; i<array.length; i++){
            array[i] = (int)(Math.random()*99);
        }
        System.out.println(Arrays.toString(array));
        int temp=0;
        stopWatch.start();
        System.out.println("Time: "+ stopWatch.getStartTime());
        for(int i=0; i< array.length-1; i++){
            for(int j=i+1; j<array.length; j++){
                if(array[i]>array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        stopWatch.stop();
        for(int i: array){
            System.out.print(i+"\t");
        }
        System.out.println("Time: "+ stopWatch.getEndTime());
        System.out.print("Time: " + stopWatch.getElapsedTime());
    }
}
