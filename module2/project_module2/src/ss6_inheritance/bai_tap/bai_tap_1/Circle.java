package ss6_inheritance.bai_tap.bai_tap_1;

public class Circle {
    private double radius;
    private String color = "no color";
    protected final double PI = 3.141592654;
    public Circle(){

    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getArea(){
        return radius * radius * PI;
    }

    @Override
    public String toString() {
        return "radius=" + radius +
                ", color='" + color + '\'' +
                ", PI=" + PI;
    }
}
