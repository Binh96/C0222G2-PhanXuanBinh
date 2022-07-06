package com.pxb.service.impl;

import com.pxb.model.RentType;
import com.pxb.repository.RentTypeRepository;
import com.pxb.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Iterable<RentType> selectAll() {
        return rentTypeRepository.findAll();
    }
}
