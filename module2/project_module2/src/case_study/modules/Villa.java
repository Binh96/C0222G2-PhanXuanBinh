package case_study.modules;

public class Villa extends Facility{
    private String roomStandard;
    private Double areaOfPool;
    private Integer numberOfFloor;

    public Villa(){

    }

    public Villa(String roomStandard, Double areaOfPool, Integer numberOfFloor){
        this.roomStandard = roomStandard;
        this.areaOfPool = areaOfPool;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String serviceCode, String serviceName, Double areaUse,
                 Integer feeArent, Integer maximumPerson, String typeOfRent, String roomStandard,
                 Double areaOfPool, Integer numberOfFloor){
        super(serviceCode, serviceName, areaUse, feeArent, maximumPerson, typeOfRent);
        this.roomStandard = roomStandard;
        this.areaOfPool = areaOfPool;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Double getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(Double areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + roomStandard +
                ", " + areaOfPool +
                ", " + numberOfFloor;
    }
}
