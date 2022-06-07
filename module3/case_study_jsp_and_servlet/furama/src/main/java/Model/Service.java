package Model;

public class Service {
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;
    private Integer typeRent;
    private Integer serviceType;
    private String standardRoom;
    private String desc;
    private Double poolArea;
    private Integer numberFloor;

    public Service() {
    }

    public Service(Integer id, String name, Integer area, Double cost, Integer maxPeople,
                   String standardRoom, String desc, Double poolArea, Integer numberFloor, Integer typeRent, Integer serviceType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.desc = desc;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Service(String name, Integer area, Double cost, Integer maxPeople,
                   String standardRoom, String desc, Double poolArea, Integer numberFloor, Integer typeRent, Integer serviceType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.desc = desc;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public Integer getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(Integer typeRent) {
        this.typeRent = typeRent;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }
}
