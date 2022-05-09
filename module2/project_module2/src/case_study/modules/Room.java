package case_study.modules;

public class Room extends Facility{
    private String freeService;

    public Room(){

    }

    public Room(String freeService){
        this.freeService = freeService;
    }

    public Room(String serviceCode, String serviceName, Double areaUse,
                Integer feeRent, Integer maximumPerson, String typeOfRent, String freeService){
        super(serviceCode, serviceName, areaUse, feeRent, maximumPerson, typeOfRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", " + freeService;
    }
}
