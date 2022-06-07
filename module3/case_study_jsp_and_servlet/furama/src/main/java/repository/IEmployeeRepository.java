package repository;

import Model.Employee;

import java.util.List;

public interface IEmployeeRepository{
    void insertEmployee(Employee employee);

    List<Employee> selectAll();

    void updateEmployee(int codeEmployee, Employee employee);

    Employee findEmployeeById(int id);

    Employee findEmployeeByName(String name);

    void deleteEmployee(int codeEmployee);
}
