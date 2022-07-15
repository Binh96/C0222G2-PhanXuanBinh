package com.pxb.service;

import com.pxb.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> selectAll(Pageable pageable);

    List<Customer> selectAll();

    void create(Customer customer);
    void edit(Customer customer);

    Customer findById(int id);

    Page<Customer> selectByName(Pageable pageable, String name);

    void deleteById(int id);
}
