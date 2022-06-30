package com.service.impl;

import com.model.Catagory;
import com.repository.CatagoryRepository;
import com.service.CatagoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatagoryServiceImpl implements CatagoryService {

    @Autowired
    private CatagoryRepository catagoryRepository;

    @Override
    public List<Catagory> selectAll() {
        return this.catagoryRepository.selectAll();
    }
}
