package ss7_abstract_and_interface.bai_tap.colorabel;

import ss7_abstract_and_interface.bai_tap.resizeable.Rectangle;
import ss7_abstract_and_interface.bai_tap.resizeable.Square;
import ss7_abstract_and_interface.bai_tap.resizeable.Circle;
import ss7_abstract_and_interface.bai_tap.resizeable.Shape;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(2, "blue", true);
        shapes[1] = new Rectangle(2, 4, "red", true);
        shapes[2] = new Square(2);

        for(Shape shape: shapes){
            System.out.println(shape);
            if(shape instanceof Colorable){
                System.out.println(((Colorable) shape).howToColor());
            }
        }
    }
}
