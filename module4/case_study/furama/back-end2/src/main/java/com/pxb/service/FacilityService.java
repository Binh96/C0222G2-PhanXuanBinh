package com.pxb.service;

import com.pxb.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacilityService {
    Page<Facility> selectAll(Pageable pageable);

    void create(Facility facility);

    void deleteById(Facility facility);

    void edit(Facility facility);

    Page<Facility> findByName(String name);

    Facility findById(int id);
}
