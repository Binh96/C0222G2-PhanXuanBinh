package ss21_design_pattern.bai_tap.factory_method;

public class FactoryMethod {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape1 = shapeFactory.getShape("Square");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("Rectangle");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("Circle");
        shape3.draw();
        Shape shape4 = shapeFactory.getShape("ádasds");
        shape4.draw();
    }
}
