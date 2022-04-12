package ss7_abstract_and_interface.bai_tap.resizeable;

public class Circle extends Shape implements Resizeable{
    private double radius;
    public Circle(){
        radius = 1.0d;
    }

    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }

    Circle(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public void resize (double percent){
        radius = radius + (radius * (percent/100));
    }

   @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius() + " and area = " + getArea()
                + ", which is a subclass of "
                + super.toString();
    }
}
