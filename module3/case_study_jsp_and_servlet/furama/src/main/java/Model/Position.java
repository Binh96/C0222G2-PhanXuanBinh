package Model;

public class Position {
    private int codePosition;
    private String name;


    public Position() {

    }

    public Position(int codePosition, String name) {
        this.codePosition = codePosition;
        this.name = name;
    }

    public int getCodePosition() {
        return codePosition;
    }

    public void setCodePosition(int codePosition) {
        this.codePosition = codePosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
