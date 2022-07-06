package com.pxb.service;

import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Page<Customer> selectAll(Pageable pageable);

    void create(Customer customer);
    void edit(Customer customer);

    Customer findById(int id);

    Page<Customer> selectByName(Pageable pageable, String name);

    void deleteById(int id);
}
