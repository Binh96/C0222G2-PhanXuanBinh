package ss21_design_pattern.thuc_hanh.object_pool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaxiThread implements Runnable{
    private TaxiPool taxiPool;

    public TaxiThread(TaxiPool taxiPool){
        this.taxiPool = taxiPool;
    }

    @Override
    public void run() {
        takeATaxi();
    }

    public void takeATaxi(){
        try{
            System.out.println("New client "+ Thread.currentThread().getName());
            Taxi taxi = taxiPool.getTaxi();
            TimeUnit.MICROSECONDS.sleep(randInt(1000, 15000));
            taxiPool.release(taxi);
            System.out.println("Served the client "+ Thread.currentThread().getName());
        }catch (InterruptedException | TaxiNotFoundException e){
            System.out.println(">>> Reject the client "+ Thread.currentThread().getName());
        }
    }

    public int randInt(int min, int max){
        return new Random().nextInt((max-min)+1)+min;
    }
}
