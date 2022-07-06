package com.pxb.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_nhan_vien")
    private String name;

    @Column(name = "ngay_sinh", columnDefinition = "date")
    private Date dateOfBirth;

    @Column(name = "cmnd")
    private String idCard;

    @Column(name = "luong", columnDefinition = "long")
    private String salary;

    @Column(name = "so_dien_thoai")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "dia_chi")
    private String address;

    @ManyToOne
    @JoinColumn(name = "ma_vi_tri", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "ma_trinh_do", referencedColumnName = "id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "ma_bo_phan", referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contracts;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    public Employee() {
    }

    public Employee(int id, String name, Date dateOfBirth, String idCard, String salary,
                    String phoneNumber, String email, String address, Position position,
                    EducationDegree educationDegree, Division division, User user, List<Contract> contracts,
                    int status) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
        this.status = status;
    }

    public Employee(String name, Date dateOfBirth, String idCard, String salary, String phoneNumber,
                    String email, String address, Position position, EducationDegree educationDegree,
                    Division division, User user, List<Contract> contracts, int status) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
