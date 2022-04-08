package ss6_inheritance.bai_tap.bai_tap_2;

public class PointTwoDimension {
    private float x;
    private float y;

    public PointTwoDimension(){

    }

    public PointTwoDimension(float x, float y){
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
        return "PointTwoDimension: {" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
