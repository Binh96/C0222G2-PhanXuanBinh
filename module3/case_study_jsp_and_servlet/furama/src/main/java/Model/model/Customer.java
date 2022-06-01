package Model.model;

import java.util.Date;

public class Customer extends Person{
    private String customerCode;
    private String customerType;
    private String address;

    public Customer(){

    }

    public Customer(String name, Date dateOfBirth, String gender, String id, String phoneMobile,
                    String email, String customerCode, String customerType, String address){
        super(name, dateOfBirth, gender, id, phoneMobile, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", " + customerCode +
                ", " + customerType +
                ", " + address;
    }
}
