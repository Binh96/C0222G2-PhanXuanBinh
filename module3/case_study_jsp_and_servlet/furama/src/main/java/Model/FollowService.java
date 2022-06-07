package Model;

public class FollowService {
    private int code;
    private String name;
    private Double cost;
    private int unit;
    private String status;


    public FollowService() {
    }

    public FollowService(int code, String name, Double cost, int unit, String status) {
        this.code = code;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
