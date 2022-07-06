package com.pxb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ngay_bat_dau", columnDefinition = "datetime")
    private Date startDate;

    @Column(name = "ngay_ket_thuc", columnDefinition = "datetime")
    private Date endDate;

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

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;
}
