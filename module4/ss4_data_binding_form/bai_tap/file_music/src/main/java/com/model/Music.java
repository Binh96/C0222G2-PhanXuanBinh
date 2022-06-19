package com.model;

public class Music {
    private String name;
    private String singer;
    private String type;
    private String path;

    public Music() {
    }

    public Music(String name, String singer, String type, String path) {
        this.name = name;
        this.singer = singer;
        this.type = type;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
