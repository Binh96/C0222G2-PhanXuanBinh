package service.impl;

import Model.Customer;
import repository.ICustomerRepository;
import repository.impl.ICustomerRepositoryImpl;
import service.ICustomerService;
import java.util.List;

public class ICustomerServiceImpl implements ICustomerService {
    ICustomerRepositoryImpl iCustomerRepository = new ICustomerRepositoryImpl

    @Override
    public List<Customer> selectAll() {
        return icustomerRepository.selectAll();
    }

    @Override
    public void insertCustomer(Customer customer) {
//        Regex regex = new Regex();
//        Map<String, String> error = new HashMap<>();
//        String name = customer.getName();
//        if(name.equals("") || name == null){
//            error.put("name","name not null");
//        }
//        else if(!regex.checkRegex(name, regex.NAME_REGEX)){
//            error.put("name", "name invalid");
//        }
//        if(){
//
//        }
        customerRepository.insertCustomer(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteCustomer(id);
    }

    @Override
    public boolean checkCustomer(int id) {
        return false;
    }

    @Override
    public void updateCustomer(int id, Customer customer) {
        customerRepository.updateCustomer(id, customer);
    }


}
