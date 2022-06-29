package com.model;

import javax.persistence.*;

@Entity
public class DetailBook {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="ten_sach", referencedColumnName = "id")
    private Book nameBook;
    private int codeOfBook;
    @Column(columnDefinition = "int default 0")
    private int status;

    public DetailBook() {
    }

    public DetailBook(Book nameBook, int codeOfBook, int status) {
        this.nameBook = nameBook;
        this.codeOfBook = codeOfBook;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getNameBook() {
        return nameBook;
    }

    public void setNameBook(Book nameBook) {
        this.nameBook = nameBook;
    }

    public int getCodeOfBook() {
        return codeOfBook;
    }

    public void setCodeOfBook(int codeOfBook) {
        this.codeOfBook = codeOfBook;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
