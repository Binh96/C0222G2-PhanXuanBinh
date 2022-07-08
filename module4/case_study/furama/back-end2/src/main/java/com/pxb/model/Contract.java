package com.pxb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_bat_dau", columnDefinition = "datetime")
    private String startDate;

    @Column(name = "ngay_ket_thuc", columnDefinition = "datetime")
    private String endDate;

    @Column(name = "tien_coc", columnDefinition = "long")
    private String deposit;

    @ManyToOne
    @JoinColumn(name = "ma_nhan_vien", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "ma_khach_hang", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu", referencedColumnName = "id")
    private Facility facility;

    @OneToMany(mappedBy = "contract")
    @JsonBackReference
    private List<ContractDetail> contractDetailList;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    public Contract() {
    }

    public Contract(int id, String startDate, String endDate, String deposit, Employee employee,
                    Customer customer, Facility facility, List<ContractDetail> contractDetailList, int status) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.contractDetailList = contractDetailList;
        this.status = status;
    }

    public Contract(String startDate, String endDate, String deposit, Employee employee,
                    Customer customer, Facility facility, List<ContractDetail> contractDetailList, int status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.contractDetailList = contractDetailList;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
