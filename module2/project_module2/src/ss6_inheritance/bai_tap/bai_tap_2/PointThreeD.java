package ss6_inheritance.bai_tap.bai_tap_2;

public class PointThreeD extends PointTwoDimension{
    private float z;

    public PointThreeD(){

    }

    public PointThreeD(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    public float getZ(){
        return this.z;
    }

    public void setZ(float z){
        this.z = z;
    }

    public float[] getXYZ(){
        float[] container = new float[3];
        container[0] = super.getX();
        container[1] = super.getY();
        container[2] = z;
        return container;
    }

    @Override
    public String toString() {
        return "PointThreeD" +
                " z= " + z +
                " which is subclass " + super.toString();
    }
}
