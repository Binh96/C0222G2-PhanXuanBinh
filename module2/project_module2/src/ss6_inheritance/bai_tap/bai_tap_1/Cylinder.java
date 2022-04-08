package ss6_inheritance.bai_tap.bai_tap_1;

public class Cylinder extends Circle{
    private double height;

    public Cylinder(){

    }

    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight(){
        return height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getVolume(){
        return getRadius()*getRadius()*super.PI*height;
    }

    public String toString(){
        return "Cylinder has height= " + height +" and volume= "+ getVolume() + " Cylinder is subclass of Circle: "+ super.toString();
    }
}
