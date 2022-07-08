package com.pxb.service.impl;

import com.pxb.model.AttachFacility;
import com.pxb.repository.AttachFacilityRepository;
import com.pxb.service.AttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements AttachFacilityService {
    @Autowired
    private AttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> selectAll() {
        return attachFacilityRepository.findAll();
    }
}
