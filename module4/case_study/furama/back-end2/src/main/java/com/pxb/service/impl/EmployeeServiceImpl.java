package com.pxb.service.impl;

import com.pxb.model.Employee;
import com.pxb.repository.EmployeeRepository;
import com.pxb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> selectAll(Pageable pageable) {
        return employeeRepository.selectAll(pageable);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void create(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Page<Employee> selectByName(Pageable pageable, String name) {
        return employeeRepository.selectByName(pageable, '%' + name + '%');
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
