package Model;

public class Level {
    private int codeLevel;
    private String name;

    public Level() {
    }

    public Level(int codeLevel, String name) {
        this.codeLevel = codeLevel;
        this.name = name;
    }

    public int getCodeLevel() {
        return codeLevel;
    }

    public void setCodeLevel(int codeLevel) {
        this.codeLevel = codeLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
