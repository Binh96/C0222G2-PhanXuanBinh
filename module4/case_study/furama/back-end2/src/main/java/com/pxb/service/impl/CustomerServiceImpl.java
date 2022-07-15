package com.pxb.service.impl;

import com.pxb.model.Customer;
import com.pxb.repository.CustomerRepository;
import com.pxb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Page<Customer> selectAll(Pageable pageable) {
        return customerRepository.selectAll(pageable);
    }

    @Override
    public List<Customer> selectAll() {
        return customerRepository.findAll();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void edit(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Page<Customer> selectByName(Pageable pageable, String name) {
        return customerRepository.selectByName(pageable, '%' + name + '%');
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }
}
