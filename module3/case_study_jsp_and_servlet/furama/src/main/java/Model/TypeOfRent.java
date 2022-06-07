package Model;

public class TypeOfRent {
    private int code;
    private String name;
    private Double typeCost;

    public TypeOfRent() {
    }

    public TypeOfRent(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public TypeOfRent(int code, String name, Double typeCost) {
        this.code = code;
        this.name = name;
        this.typeCost = typeCost;
    }

    public Double getTypeCost() {
        return typeCost;
    }

    public void setTypeCost(Double typeCost) {
        this.typeCost = typeCost;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
