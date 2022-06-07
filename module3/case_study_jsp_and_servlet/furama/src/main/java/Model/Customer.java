package Model;

import java.util.Date;

public class Customer extends Person{
    private Integer customerCode;
    private Integer customerType;

    public Customer(){

    }

    public Customer(Integer customerCode, String name, Date dateOfBirth, Integer gender, String id, String phoneMobile,
                    String email, String address, Integer customerType){
        super(name, dateOfBirth, gender, id, phoneMobile, email, address);
        this.customerCode = customerCode;
        this.customerType = customerType;
    }

    public Customer(String name, Date dateOfBirth, Integer gender, String id, String phoneMobile,
                    String email, String address, Integer customerType){
        super(name, dateOfBirth, gender, id, phoneMobile, email, address);
        this.customerType = customerType;
    }

    public Integer getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(Integer customerCode) {
        this.customerCode = customerCode;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }


    @Override
    public String toString() {
        return super.toString()+
                ", " + customerCode +
                ", " + customerType;
    }
}
