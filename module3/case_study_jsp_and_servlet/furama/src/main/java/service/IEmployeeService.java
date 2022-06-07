package service;

import Model.Employee;

import java.util.Date;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAll();
    void addEmployee(String name, Date dob, String cmnd, Integer gender, Long salary,
                     String numberPhone, String email, String address, Integer codePosition,
                     Integer codeLevel, Integer codeTask);
    void updateEmployee(int codeEmployee, Employee employee);
    Employee findEmployeeById(int id);
    Employee findEmployeeByName(String name);
    void deleteEmployee(int id);
}
