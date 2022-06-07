package service;

import Model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAll();

    void insertCustomer(Customer customer);

    Customer findById(int id);

    Customer findByName(String name);

    void deleteCustomer(int id);

    boolean checkCustomer(int id);

    void updateCustomer(int id, Customer customer);
}
