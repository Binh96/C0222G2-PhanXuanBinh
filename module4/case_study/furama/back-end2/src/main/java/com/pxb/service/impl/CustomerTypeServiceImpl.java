package com.pxb.service.impl;

import com.pxb.model.CustomerType;
import com.pxb.repository.CustomerTypeRepository;
import com.pxb.service.CustomerTypeService;
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
