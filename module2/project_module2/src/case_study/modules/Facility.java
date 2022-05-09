package case_study.modules;

import java.util.Objects;

public abstract class Facility {
    private String serviceCode;
    private String serviceName;
    private Double areaUse;
    private Integer feeRent;
    private Integer maximumPerson;
    private String typeOfRent;

    public Facility(){

    }

    public Facility(String serviceCode, String serviceName, Double areaUse, Integer feeRent, Integer maximumPerson, String typeOfRent){
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.areaUse = areaUse;
        this.feeRent = feeRent;
        this.maximumPerson = maximumPerson;
        this.typeOfRent = typeOfRent;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(Double areaUse) {
        this.areaUse = areaUse;
    }

    public Integer getFeeRent() {
        return feeRent;
    }

    public void setFeeRent(Integer feeRent) {
        this.feeRent = feeRent;
    }

    public Integer getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(Integer maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(String typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    @Override
    public String toString() {
        return serviceCode +
                ", " + serviceName +
                ", " + areaUse +
                ", " + feeRent +
                ", " + maximumPerson +
                ", " + typeOfRent;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){
            return true;
        }
        if(!(o instanceof Facility facility)){
            return false;
        }
        return Objects.equals(serviceName, facility.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }
}
