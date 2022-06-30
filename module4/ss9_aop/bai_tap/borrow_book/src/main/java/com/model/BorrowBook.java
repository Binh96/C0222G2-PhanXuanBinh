package com.model;

import javax.persistence.*;

@Entity
@Table(name="sach_da_muon")
public class BorrowBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int codeOfBorrow;

    public BorrowBook() {
    }

    public BorrowBook(int codeOfBorrow) {
        this.codeOfBorrow = codeOfBorrow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodeOfBorrow() {
        return codeOfBorrow;
    }

    public void setCodeOfBorrow(int codeOfBorrow) {
        this.codeOfBorrow = codeOfBorrow;
    }
}
