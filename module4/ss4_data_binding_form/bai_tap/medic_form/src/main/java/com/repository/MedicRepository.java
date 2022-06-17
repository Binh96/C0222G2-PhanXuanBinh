package com.repository;

import com.model.MedicForm;

import java.util.List;

public interface MedicRepository {
    void save(MedicForm medicForm);
    List<MedicForm> selectAll();
}
