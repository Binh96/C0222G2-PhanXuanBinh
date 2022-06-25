package com.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "the_loai_nhac", referencedColumnName = "id")
    private Type type;

    @Column(name = "bai_hat")
    private String path;

    public Music() {
    }

    public Music(int id, String name, Type type, String path) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.path = path;
    }

    public Music(String name, Type type, String path) {
        this.name = name;
        this.type = type;
        this.path = path;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
