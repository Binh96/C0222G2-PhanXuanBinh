package com.pxb.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "danh_muc")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private List<Post> post;

    public Category() {
    }

    public Category(int id, String name, List<Post> post) {
        this.id = id;
        this.name = name;
        this.post = post;
    }

    public Category(String name, List<Post> post) {
        this.name = name;
        this.post = post;
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

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }
}
