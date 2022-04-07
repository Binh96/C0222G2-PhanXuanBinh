package ss5_access_modifier_static_method.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){
    }

    Circle(double r){
        this.radius = r;
    }

    public double getRadius(){
        return radius;
    }

    public double getArea(){
        return radius*3.14;
    }
}
