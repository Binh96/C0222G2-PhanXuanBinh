package ss4_class_and_object_in_java.bai_tap;


public class MainStopWatch {
    public static void main(String[] args) {
        StopWatch  stopWatch = new StopWatch();
        int[] array = new int[100000];
        for(int i=0; i<array.length; i++){
            array[i] = i;
        }
        int temp;
        temp = array[1];
        array[1] = array[array.length-1];
        array[array.length-1] = temp;

        int n = array[0];
        stopWatch.start();
        System.out.println("Time: "+ stopWatch.getStartTime());
        for(int i: array){
            if(n > i){
                n = i;
            }
        }
        stopWatch.stop();
        System.out.println("Time: "+ stopWatch.getEndTime());
        System.out.print("Time: " + stopWatch.getElapsedTime());
    }
}
