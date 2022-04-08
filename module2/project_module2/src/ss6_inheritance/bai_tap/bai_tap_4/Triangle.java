package ss6_inheritance.bai_tap.bai_tap_4;


public class Triangle extends Shape {
    private double side1 = 1.0d;
    private double side2 = 1.0d;
    private double side3 = 1.0d;
    private double height = 1.0d;

    public Triangle(){

    }
    public Triangle(String color){
        super(color);
    }

    Triangle(double side1, double side2, double side3, double height, String color){
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.height = height;
    }

    public double getSide1(){
        return side1;
    }

    public double getSide2(){
        return side2;
    }

    public double getSide3(){
        return side3;
    }

    public void setSide1(double side1){
        this.side1 = side1;
    }

    public void setSide2(double side2){
        this.side2 = side2;
    }

    public void setSide3(double side3){
        this.side3 = side3;
    }

    public double[] getSide(){
        double[] container = new double[3];
        container[0] = side1;
        container[1] = side2;
        container[2] = side3;
        return container;
    }

    public void setSide(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
            // tam giác cân
    private boolean isIsoscelesTriangle(){
        if(side1==side2 || side1 == side3 || side3 == side2){
            return true;
        }
        return false;
    }
            // tam giác đều
    private boolean isEquilateralTriangle(){
        if(side1 == side2 && side1 == side3){
            return true;
        }
        return false;
    }
        // tam giác thường
    private boolean isNormalTriangle(){
        if(side1!=side2 && side2!=side3){
            return true;
        }
        return false;
    }

            // tính diện tích
    public double getArea(){
        double result=0;
        if(isIsoscelesTriangle()){
            result = ((double) 1/2)*side3*height;
        }
        if(isEquilateralTriangle()){
            result = (Math.pow(side1, 2)*(Math.sqrt(3)/4)) ;
        }
        if(isNormalTriangle()){
            result = ((double)1/2) * side1 * height;
        }
        return result;
    }

    private String triangleShape(){
        String str= "";
        if(isEquilateralTriangle()){
            str = "triangle is equilateral triangle";
        }
        else if(isIsoscelesTriangle()){
            str = "triangle is isosceles triangle";
        }

        else if(isNormalTriangle()){
            str = "triangle is normal triangle";
        }
        return str;
    }

    @Override
    public String toString() {
        return "Triangle: ["+ side1 +", "+ side2+", "+side3+"] "+ triangleShape() +" has area= "+getArea()
                +", which is subclass of "+ super.toString();
    }
}
