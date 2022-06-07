package service.impl;

import Model.Employee;
import Model.repository.impl.IEmployeeRepoImpl;
import service.IEmployeeService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class IEmployeeServiceImpl implements IEmployeeService {
    Scanner sc = new Scanner(System.in);
    IEmployeeRepoImpl employeeRepo = new IEmployeeRepoImpl();

    @Override
    public List<Employee> selectAll() {
        return employeeRepo.selectAll();
    }

    public void addEmployee(String name, Date dob, String cmnd, Integer gender, Long salary,
    String numberPhone, String email, String address, Integer codePosition, Integer codeLevel, Integer codeTask){
        Employee employee = new Employee(name, gender, dob, cmnd, salary, numberPhone, email, address, codePosition
        , codeLevel, codeTask);

        employeeRepo.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(int codeEmployee, Employee employee) {
        employeeRepo.updateEmployee(codeEmployee, employee);
    }

    public Employee findEmployeeById(int id){
        return employeeRepo.findEmployeeById(id);
    }

    @Override
    public Employee findEmployeeByName(String name) {
        return employeeRepo.findEmployeeByName(name);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteEmployee(id);
    }
}
