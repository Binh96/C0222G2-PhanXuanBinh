package ss4_class_and_object_in_java.bai_tap;


public class StopWatch {

    private long startTime;
    private long endTime;

    StopWatch(){
        this.startTime = System.currentTimeMillis();
    }


    public long getStartTime(){

        return this.startTime;
    }

    public long getEndTime(){

        return this.endTime;
    }

    public void start(){

        this.startTime = System.currentTimeMillis();
    }

    public void stop(){

        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime(){

        return (this.endTime - this.startTime);
    }

}
