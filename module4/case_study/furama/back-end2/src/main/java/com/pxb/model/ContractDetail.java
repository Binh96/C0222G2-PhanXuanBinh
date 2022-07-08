package com.pxb.model;

import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;

@Entity
@Table(name = "hop_dong_chi_tiet")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong", referencedColumnName = "id")
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "ma_dich_vu_di_kem", referencedColumnName = "id")
    private AttachFacility attachFacility;

    @Column(name = "status", columnDefinition = "int default 0")
    private int status;

    public ContractDetail() {
    }

    public ContractDetail(int id, Contract contract, AttachFacility attachFacility, int status) {
        this.id = id;
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.status = status;
    }

    public ContractDetail(Contract contract, AttachFacility attachFacility, int status) {
        this.contract = contract;
        this.attachFacility = attachFacility;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
