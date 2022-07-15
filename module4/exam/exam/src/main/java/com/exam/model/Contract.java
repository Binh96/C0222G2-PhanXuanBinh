package com.exam.model;

import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_hop_dong")
    private String codeContract;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ma_phong", referencedColumnName = "id")
    private Room room;

    @Column(name = "ten_nguoi_thue")
    private String name;

    @Column(name = "so_chung_minh_nhan_dan")
    private String idCard;

    @Column(name = "ngay_lam_hop_dong")
    private String dateDoContract;

    @Column(name= "thoi_gian_thue")
    private String timeForRent;


    public Contract() {
    }

    public Contract(String codeContract, Room room, String name, String idCard, String dateDoContract, String timeForRent) {
        this.codeContract = codeContract;
        this.room = room;
        this.name = name;
        this.idCard = idCard;
        this.dateDoContract = dateDoContract;
        this.timeForRent = timeForRent;
    }

    public Contract(int id, String codeContract, Room room, String name, String idCard, String dateDoContract, String timeForRent) {
        this.id = id;
        this.codeContract = codeContract;
        this.room = room;
        this.name = name;
        this.idCard = idCard;
        this.dateDoContract = dateDoContract;
        this.timeForRent = timeForRent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getCodeContract() {
        return codeContract;
    }

    public void setCodeContract(String codeContract) {
        this.codeContract = codeContract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDateDoContract() {
        return dateDoContract;
    }

    public void setDateDoContract(String dateDoContract) {
        this.dateDoContract = dateDoContract;
    }

    public String getTimeForRent() {
        return timeForRent;
    }

    public void setTimeForRent(String timeForRent) {
        this.timeForRent = timeForRent;
    }
}
