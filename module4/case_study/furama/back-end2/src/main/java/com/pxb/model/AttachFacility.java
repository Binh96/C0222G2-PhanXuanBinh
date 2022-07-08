package com.pxb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu_di_kem")
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_dich_vu_di_kem")
    private String name;

    @Column(name = "gia", columnDefinition = "long")
    private String cost;

    @Column(name = "don_vi")
    private String unit;

    @OneToMany(mappedBy = "attachFacility")
    @JsonBackReference
    private List<ContractDetail> contractDetailList;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    public AttachFacility() {
    }

    public AttachFacility(int id, String name, String cost, String unit,
                          List<ContractDetail> contractDetailList, int status) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.contractDetailList = contractDetailList;
        this.status = status;
    }

    public AttachFacility(String name, String cost, String unit,
                          List<ContractDetail> contractDetailList, int status) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.contractDetailList = contractDetailList;
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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
