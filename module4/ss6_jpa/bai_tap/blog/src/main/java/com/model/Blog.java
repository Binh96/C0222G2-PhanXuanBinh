package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    @Column(name = "date_post", columnDefinition = "datetime")
    private Date datePost;
    private String img;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date datePost, String img) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.img = img;
    }

    public Blog(String title, String content, Date datePost, String img) {
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
