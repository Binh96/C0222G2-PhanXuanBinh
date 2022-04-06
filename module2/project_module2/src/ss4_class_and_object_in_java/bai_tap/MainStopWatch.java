package ss4_class_and_object_in_java.bai_tap;


public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch  watch = new StopWatch();
        int[] array = new int[100000];
        System.out.println("Time: "+ watch.getStartTime());
        for(int i=0; i<array.length; i++){
            array[i] = i;
        }
        int temp;
        temp = array[1];
        array[1] = array[array.length-1];
        array[array.length-1] = temp;

        int n = array[0];
        int time=0;
        for(int i: array){
            if(n > i){
                n = i;
            }
            time = watch.getElapsedTime();
        }
        System.out.print("Time: " + time);
    }
}
