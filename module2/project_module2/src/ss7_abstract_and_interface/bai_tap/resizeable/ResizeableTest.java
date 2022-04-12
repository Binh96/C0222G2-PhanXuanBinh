package ss7_abstract_and_interface.bai_tap.resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(2,4);
        shapes[2] = new Square(3);
        //    Area before resize
        for(Shape i: shapes){
            System.out.println(i);
        }
        double percent = Math.round((Math.random()* 100));
        System.out.println(percent);
        //      Area after resize
        System.out.println("Shape after resize");
        for(Shape shape: shapes){
            if(shape instanceof Circle){
                ((Circle) shape).resize(percent);
                System.out.println(shape);
            }
            else if(shape instanceof Square){
                ((Square) shape).resize(percent);
                System.out.println(shape);
            }
            else if(shape instanceof Rectangle){
                ((Rectangle) shape).resize(percent);
                System.out.println(shape);
            }
        }
    }
}
