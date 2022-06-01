package Model.model;

import java.util.Date;

public class Employee extends Person{
    private static int employeeCode = 1;
    private int currentCode;
    private String level;
    private String position;
    private Long salary;

    public Employee(){

    }

    public Employee(String name, Date dateOfBirth, String gender, String id, String phoneMobile,
                    String email, int code, String level, String position, Long salary){
        super(name, dateOfBirth, gender, id, phoneMobile, email);
        this.currentCode = code;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, Date dateOfBirth, String gender, String id, String phoneMobile,
                    String email, String level, String position, Long salary){
        super(name, dateOfBirth, gender, id, phoneMobile, email);
        Employee.employeeCode += 1;
        this.currentCode = Employee.employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public static int getEmployeeCode() {
        return Employee.employeeCode;
    }

    public static void setEmployeeCode(int employeeCode) {
        Employee.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public int getCurrentCode() {
        return currentCode;
    }

    public void setCurrentCode(int currentCode) {
        this.currentCode = currentCode;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", " + currentCode +
                ", " + level +
                ", " + position +
                ", " + salary;
    }

    public String getInfor(){
        return super.getInfor() + "ID= "+ currentCode+ ", level= " + level+ ", position= " + position
                + ", salary= " + salary;
    }
}
