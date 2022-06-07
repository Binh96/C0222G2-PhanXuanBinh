package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Person {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String name;
    private Date dateOfBirth;
    private Integer gender;
    private String id;
    private String phoneMobile;
    private String email;
    private String address;

    public Person(){

    }

    public Person(String name, Date dateOfBirth, Integer gender, String id, String phoneMobile, String email, String address){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        this.phoneMobile = phoneMobile;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return name +
                ", " + simpleDateFormat.format(dateOfBirth) +
                ", " + gender +
                ", " + id +
                ", " + phoneMobile +
                ", " + email +
                ", " + email;
    }

    public String getInfor(){
        return "name= " + name +", date of birth= " + simpleDateFormat.format(dateOfBirth)
                + ", gender= " + gender + ", ID= " + id + ", phone number= " + phoneMobile
                + ", email= " + email+ ", email= " + address;
    }
}
