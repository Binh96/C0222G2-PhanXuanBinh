package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "danh_muc")
    private String catagoryName;

    @OneToMany(mappedBy = "catagory")
    private List<Post> posts;

    public Catagory() {
    }

    public Catagory(int id, String catagoryName, List<Post> posts) {
        this.id = id;
        this.catagoryName = catagoryName;
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(String catagoryName) {
        this.catagoryName = catagoryName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
