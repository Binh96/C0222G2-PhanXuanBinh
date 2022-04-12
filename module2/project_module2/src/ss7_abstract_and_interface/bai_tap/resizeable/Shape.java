package ss7_abstract_and_interface.bai_tap.resizeable;

public class Shape {
    private String color;
    private boolean filled;

    Shape(){
        color = "green";
        filled = true;
    }

    Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){
        return this.filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    @Override
    public String toString(){
        return "A Shape with color of "+ color +" and " + (isFilled() ? " filled" : " not filled");
    }
}
