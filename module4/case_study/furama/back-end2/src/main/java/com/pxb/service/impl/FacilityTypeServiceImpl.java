package com.pxb.service.impl;

import com.pxb.model.FacilityType;
import com.pxb.repository.FacilityTypeRepository;
import com.pxb.service.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {
    @Autowired
    private FacilityTypeRepository facilityTypeRepository;

    @Override
    public Iterable<FacilityType> selectAll() {
        return facilityTypeRepository.findAll();
    }
}
