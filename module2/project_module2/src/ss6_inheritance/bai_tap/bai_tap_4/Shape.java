package ss6_inheritance.bai_tap.bai_tap_4;

public class Shape {
    String color="red";

    public Shape(){

    }

    public Shape(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape" +
                " color= " + color;
    }
}
