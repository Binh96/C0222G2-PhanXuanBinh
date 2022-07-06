package com.pxb.service.impl;

import com.pxb.model.Division;
import com.pxb.repository.DivisionRepository;
import com.pxb.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {
    @Autowired
    private DivisionRepository divisionRepository;
    @Override
    public List<Division> selectAll() {
        return divisionRepository.findAll();
    }
}
