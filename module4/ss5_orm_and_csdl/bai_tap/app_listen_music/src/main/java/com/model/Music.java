package com.model;

import javax.persistence.*;

@Entity
@Table
public class Music {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nameSong;
    private String nameSinger;
    private String typeSong;
    private String pathSong;

    public Music() {
    }

    public Music(int id, String nameSong, String nameSinger, String typeSong, String pathSong) {
        this.id = id;
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.typeSong = typeSong;
        this.pathSong = pathSong;
    }

    public Music(String nameSong, String nameSinger, String typeSong, String pathSong) {
        this.nameSong = nameSong;
        this.nameSinger = nameSinger;
        this.typeSong = typeSong;
        this.pathSong = pathSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getTypeSong() {
        return typeSong;
    }

    public void setTypeSong(String typeSong) {
        this.typeSong = typeSong;
    }

    public String getPathSong() {
        return pathSong;
    }

    public void setPathSong(String pathSong) {
        this.pathSong = pathSong;
    }
}
