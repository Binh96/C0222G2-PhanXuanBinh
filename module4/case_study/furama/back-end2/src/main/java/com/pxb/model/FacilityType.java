package com.pxb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loai_dich_vu")
public class FacilityType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_loai_dich_vu")
    private String name;

    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilityList;

    public FacilityType() {
    }

    public FacilityType(String name, List<Facility> facilityList) {
        this.name = name;
        this.facilityList = facilityList;
    }

    public FacilityType(int id, String name, List<Facility> facilityList) {
        this.id = id;
        this.name = name;
        this.facilityList = facilityList;
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

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
