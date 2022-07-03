package com.pxb.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tieu_de")
    private String heading;

    @Column(name = "noi_dung")
    private String content;

    @Column(name = "ngay_dang", columnDefinition = "date")
    private Date datePost;

    @Column(name = "tac_gia")
    private String author;

    @Column(name = "anh")
    private String img;

    @Column(name = "mo_ta")
    private String description;

    @ManyToOne
    @JoinColumn(name = "danh_muc", referencedColumnName = "id")
    private Category category;

    public Post() {
    }

    public Post(String heading, String content, Date datePost, String author, String img, String description, Category category) {
        this.heading = heading;
        this.content = content;
        this.datePost = datePost;
        this.author = author;
        this.img = img;
        this.description = description;
        this.category = category;
    }

    public Post(int id, String heading, String content, Date datePost, String author, String img, String description, Category category) {
        this.id = id;
        this.heading = heading;
        this.content = content;
        this.datePost = datePost;
        this.author = author;
        this.img = img;
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
