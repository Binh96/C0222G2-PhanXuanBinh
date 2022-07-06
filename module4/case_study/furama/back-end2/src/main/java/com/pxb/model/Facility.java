package com.pxb.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dich_vu")
public class Facility {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_dich_vu")
    private String name;

    @Column(name = "dien_tich")
    private String area;

    @Column(name = "gia", columnDefinition = "long")
    private String cost;

    @Column(name = "so_luong_nguoi")
    private int maxPeople;

    @ManyToOne
    @JoinColumn(name = "kieu_thue", referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "loai_dich_vu", referencedColumnName = "id")
    private FacilityType facilityType;

    @Column(name = "loai_phong")
    private String standardRoom;

    @Column(name = "mo_ta")
    private String description;

    @Column(name = "dien_tich_ho_boi", columnDefinition = "long")
    private String poolArea;

    @Column(name = "so_tang")
    private int numberOfFloor;

    @Column(name = "dich_vu_mien_phi")
    private String facilityFree;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    @OneToMany(mappedBy = "facility")
    private List<Contract> contracts;

    public Facility() {
    }

    public Facility(String name, String area, String cost, int maxPeople, RentType rentType,
                    FacilityType facilityType, String standardRoom, String description,
                    String poolArea, int numberOfFloor, String facilityFree, int status, List<Contract> contracts) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.status = status;
        this.contracts = contracts;
    }

    public Facility(int id, String name, String area, String cost, int maxPeople,
                    RentType rentType, FacilityType facilityType, String standardRoom,
                    String description, String poolArea, int numberOfFloor, String facilityFree,
                    int status, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.facilityFree = facilityFree;
        this.status = status;
        this.contracts = contracts;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
