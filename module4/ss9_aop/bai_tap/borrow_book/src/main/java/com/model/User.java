package com.model;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ma_so_muon_sach")
    private int codeOfBorrow;

    @ManyToOne
    @JoinColumn(name = "sach", referencedColumnName = "id")
    private Book book;

    public User() {
    }

    public User(int id, int codeOfBorrow, Book book) {
        this.id = id;
        this.codeOfBorrow = codeOfBorrow;
        this.book = book;
    }

    public User(int codeOfBorrow, Book book) {
        this.codeOfBorrow = codeOfBorrow;
        this.book = book;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
