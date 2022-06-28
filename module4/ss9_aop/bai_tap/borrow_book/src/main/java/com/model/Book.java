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

    @Column(name = "so_luong", columnDefinition = "integer default 5")
    private int quantity;

    @OneToMany(mappedBy = "book")
    private List<User> users;

    public Book() {
    }

    public Book(int id, String nameOfBook, String author, int quantity, List<User> users) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.quantity = quantity;
        this.users = users;
    }

    public Book(String nameOfBook, String author, int quantity, List<User> users) {
        this.nameOfBook = nameOfBook;
        this.author = author;
        this.quantity = quantity;
        this.users = users;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void borrowBook(){
        if(this.quantity > 0){
            this.setQuantity(this.quantity - 1) ;
        }
        else{
            System.out.println("Error");
        }
    }

    public void payBook(){
        this.setQuantity(this.quantity + 1);
    }
}
