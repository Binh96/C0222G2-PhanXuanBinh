package com.model;

import javax.persistence.*;

@Entity
@Table()
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ho_va_ten")
    private String name;

    @Column(name = "dia_chi")
    private String address;

    @Column(name ="ma_muon_sach")
    private int codeOfBorrow;


}
