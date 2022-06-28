package com.service.impl;

import com.model.CustomerType;
import com.repository.CustomerTypeRepository;
import com.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;


    @Override
    public List<CustomerType> selectAll() {
        return customerTypeRepository.findAll();
    }
}
