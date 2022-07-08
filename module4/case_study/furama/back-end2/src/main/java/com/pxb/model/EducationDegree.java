package com.pxb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="trinh_do")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_trinh_do")
    private String educationDegree;

    @OneToMany(mappedBy = "position")
    @JsonBackReference
    private List<Employee> employeeList;

    public EducationDegree() {
    }

    public EducationDegree(String educationDegree, List<Employee> employeeList) {
        this.educationDegree = educationDegree;
        this.employeeList = employeeList;
    }

    public EducationDegree(int id, String educationDegree, List<Employee> employeeList) {
        this.id = id;
        this.educationDegree = educationDegree;
        this.employeeList = employeeList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
