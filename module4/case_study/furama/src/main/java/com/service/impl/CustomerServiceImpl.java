package com.service.impl;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> selectAll() {
        return customerRepository.findAll();
    }
}
