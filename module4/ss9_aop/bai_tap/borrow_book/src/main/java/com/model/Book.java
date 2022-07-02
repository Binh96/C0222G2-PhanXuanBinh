package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table()
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameOfBook;
    private String author;

    @Column(name="luu_tru")
    private int storage;

    @OneToMany(mappedBy = "nameBook")
    private List<DetailBook> detailBooks;
    @Column(name = "so_luong", columnDefinition = "integer default 5")
    private int quantity;


    public Book() {
    }

    public Book(String nameOfBook, String author, int storage, List<DetailBook> detailBooks, int quantity) {
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.storage = storage;
        this.detailBooks = detailBooks;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public List<DetailBook> getDetailBooks() {
        return detailBooks;
    }

    public void setDetailBooks(List<DetailBook> detailBooks) {
        this.detailBooks = detailBooks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
