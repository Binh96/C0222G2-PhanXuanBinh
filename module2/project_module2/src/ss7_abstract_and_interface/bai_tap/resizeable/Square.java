package ss7_abstract_and_interface.bai_tap.resizeable;

import ss7_abstract_and_interface.bai_tap.colorabel.Colorable;

public class Square extends Rectangle implements Resizeable, Colorable {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setLength(side);
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    public String howToColor(){
        return "Color all four side";
    }

    @Override
    public void setLength(double length) {
        setSide(length);
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide() + " and area = " + getArea()
                + ", which is a subclass of "
                + super.toString();
    }
}
