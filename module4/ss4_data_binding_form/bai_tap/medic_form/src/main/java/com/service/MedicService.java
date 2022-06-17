package com.service;

import com.model.MedicForm;

import java.util.List;

public interface MedicService {
    void save(MedicForm medicForm);
    List<MedicForm> selectAll();
}
