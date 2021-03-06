package com.pxb.service;

import com.pxb.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    Page<Employee> selectAll(Pageable pageable);

    List<Employee> selectAll();

    void create(Employee employee);
    void edit(Employee employee);

    Employee findById(int id);

    Page<Employee> selectByName(Pageable pageable, String name);

    void deleteById(int id);
}
