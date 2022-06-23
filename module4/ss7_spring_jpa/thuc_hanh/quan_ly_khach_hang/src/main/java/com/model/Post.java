package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tieu_de")
    private String title;

    @Column(name = "noi_dung")
    private String content;

    @Column(name = "ngay_dang", columnDefinition = "date")
    private Date datePost;

    @Column(name="hinh_anh")
    private String imgPath;

    @Column(name = "luot_thich")
    private Integer like;

    @Column(name = "khong_thich")
    private Integer dislike;

    @Column(name = "mo_ta")
    private String description;

    @ManyToOne
    @JoinColumn(name = "catagory_id", referencedColumnName = "id")
    private Catagory catagory;

    public Post(){

    }

    public Post(String title, String content, String imgPath){
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
    }

    public Post(int id, String title, String content, Date datePost, String imgPath,
                Integer like, Integer dislike, String description, Catagory catagory) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.imgPath = imgPath;
        this.like = like;
        this.dislike = dislike;
        this.description = description;
        this.catagory = catagory;
    }

    public Post(String title, String content, String imgPath, String desc, Date datePost){
        this.title = title;
        this.content = content;
        this.imgPath = imgPath;
        this.description = desc;
        this.datePost = datePost;
    }

    public Post(int id, String title, String content, Date datePost, String imgPath, Integer like,
                Integer dislike, String description) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.imgPath = imgPath;
        this.like = like;
        this.dislike = dislike;
        this.description = description;
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

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(Catagory catagory) {
        this.catagory = catagory;
    }
}
