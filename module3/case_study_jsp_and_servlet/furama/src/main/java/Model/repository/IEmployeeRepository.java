package Model.repository;

import Model.model.Employee;

public interface IEmployeeRepository extends IFuramaRepository{
    void insertEmployee(Employee employee);


}
