package Model;

import java.util.Date;

public class Employee extends Person{
    private int currentCode;
    private Integer level;
    private Integer position;
    private Long salary;
    private Integer codeTask;

    public Employee(){

    }

    public Employee(String name, Date dateOfBirth, Integer gender, String id, String phoneMobile,
                    String email, int code, Integer level, Integer position, Long salary, String address){
        super(name, dateOfBirth, gender, id, phoneMobile, email, address);
        this.currentCode = code;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }
    public Employee(String name, Date dateOfBirth, Integer gender, String id, String phoneMobile,
                    String email, int code, Integer level, Integer position, Long salary, Integer codeTask, String address){
        super(name, dateOfBirth, gender, id, phoneMobile, email, address);
        this.currentCode = code;
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.codeTask = codeTask;
    }

    public Employee(int currentCode, String name, Date dateOfBirth, Integer gender, String id, String phoneMobile,
                    String email, Integer level, Integer position, Long salary, String address, int codeTask){
        super(name, dateOfBirth, gender, id, phoneMobile, email,address);
        this.currentCode = currentCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.codeTask = codeTask;
    }

    public Employee(String name, Integer gender, Date dateOfBirth, String id, Long salary, String phoneMobile,
                    String email, String address, Integer position, Integer level, Integer codeTask){
        super(name, dateOfBirth, gender, id, phoneMobile, email,address);
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.codeTask = codeTask;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
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

    public Integer getCodeTask() {
        return codeTask;
    }

    public void setCodeTask(Integer codeTask) {
        this.codeTask = codeTask;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", " + currentCode +
                ", " + level +
                ", " + position +
                ", " + salary+", " + codeTask;
    }

    public String getInfor(){
        return super.getInfor() + "ID= "+ currentCode+ ", level= " + level+ ", position= " + position
                + ", salary= " + salary + ", code task= " + codeTask;
    }
}
