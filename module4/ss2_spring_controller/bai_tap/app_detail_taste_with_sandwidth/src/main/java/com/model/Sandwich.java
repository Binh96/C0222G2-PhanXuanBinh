package com.model;

import java.util.List;

public class Sandwich {
    private List<String> taste;

    public Sandwich() {
    }

    public Sandwich(List<String> taste) {
        this.taste = taste;
    }

    public List<String> getTaste() {
        return taste;
    }

    public void setTaste(List<String> taste) {
        this.taste = taste;
    }
}
