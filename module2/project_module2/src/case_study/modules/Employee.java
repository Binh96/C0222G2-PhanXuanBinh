package case_study.modules;

import java.util.Date;

public class Employee extends Person{
    private String employeeCode;
    private String level;
    private String position;
    private Long salary;

    public Employee(){

    }

    public Employee(String name, Date dateOfBirth, String gender, String id, String phoneMobile,
                    String email, String employeeCode, String level, String position, Long salary){
        super(name, dateOfBirth, gender, id, phoneMobile, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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

    @Override
    public String toString() {
        return super.toString()+
                ", " + employeeCode +
                ", " + level +
                ", " + position +
                ", " + salary;
    }
}
