package com.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "the_loai")
public class Type {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ten_the_loai")
    private String typeMusic;

    @OneToMany(mappedBy = "type")
    private List<Music> music;

    public Type() {
    }

    public Type(int id, String typeMusic, List<Music> music) {
        this.id = id;
        this.typeMusic = typeMusic;
        this.music = music;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }

    public List<Music> getMusic() {
        return music;
    }

    public void setMusic(List<Music> music) {
        this.music = music;
    }
}
