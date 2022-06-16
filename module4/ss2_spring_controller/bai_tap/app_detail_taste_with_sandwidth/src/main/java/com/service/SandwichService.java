package com.service;

import com.model.Sandwich;

import java.util.List;

public interface SandwichService {
    void save(String[] taste);
    List<String> getAllTaste();
}
