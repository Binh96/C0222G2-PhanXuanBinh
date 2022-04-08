package ss6_inheritance.bai_tap.bai_tap_3;

public class Point {
    float x;
    float y;

    public Point(){

    }

    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y =y;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        float[] container = new float[2];
        container[0] = x;
        container[1] = y;
        return container;
    }

    @Override
    public String toString() {
        return "("+x+", "+y+")";
    }
}
