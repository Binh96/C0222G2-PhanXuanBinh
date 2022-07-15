package com.pxb.service.impl;

import com.pxb.model.Facility;
import com.pxb.repository.FacilityRepository;
import com.pxb.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {
    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public Page<Facility> selectAll(Pageable pageable) {
        return facilityRepository.selectAll(pageable);
    }

    @Override
    public List<Facility> selectAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void create(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void deleteById(Facility facility) {
        facilityRepository.deleteById(facility.getId());
    }

    @Override
    public void edit(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public Page<Facility> findByName(Pageable pageable,String name) {
        return facilityRepository.selectByName(pageable,name);
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id);
    }
}
