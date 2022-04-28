package ss21_design_pattern.bai_tap.factory_method;

public class ShapeFactory {
    public Shape getShape(String str){
        if("Square".equals(str)){
            return new Square();
        }
        else if("Rectangle".equals(str)){
            return new Rectangle();
        }
        else{
            return new Circle();
        }
    }
}
