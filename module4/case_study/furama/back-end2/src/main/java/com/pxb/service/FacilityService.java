package com.pxb.service;

import com.pxb.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FacilityService {
    Page<Facility> selectAll(Pageable pageable);
    List<Facility> selectAll();


    void create(Facility facility);

    void deleteById(Facility facility);

    void edit(Facility facility);

    Page<Facility> findByName(Pageable pageable, String name);

    Facility findById(int id);
}
