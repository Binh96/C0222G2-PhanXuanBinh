package ss4_class_and_object_in_java.bai_tap;

import java.time.LocalTime;

public class StopWatch {

    private LocalTime startTime;
    private LocalTime endTime;

    StopWatch(){
        this.startTime = java.time.LocalTime.now();
    }

    StopWatch(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime(){
        return this.startTime;
    }

    public void setStartTime(LocalTime newStartTime){
        this.startTime = newStartTime;
    }

    public LocalTime getEndTime(){
        return this.endTime;
    }

    public void setEndTime(LocalTime newEndTime){
        this.endTime = newEndTime;
    }

    public LocalTime getStart() {
        return startTime;
    }

    public LocalTime getStop() {
        return endTime;
    }
        public int getElapsedTime(){
        int miliseconds = ((endTime.getHour() - startTime.getHour()) * 3600 +
                (endTime.getMinute() - startTime.getMinute()) * 60 +
                (endTime.getSecond() - startTime.getSecond())) * 1000;
        return miliseconds;
    }
}
