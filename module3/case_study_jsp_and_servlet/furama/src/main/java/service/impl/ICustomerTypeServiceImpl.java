package service.impl;


import Model.TypeOfCustomer;
import Model.repository.impl.ICustomerTypeRepositoryImpl;
import service.ICustomerTypeService;

import java.util.List;

public class ICustomerTypeServiceImpl implements ICustomerTypeService {
    ICustomerTypeRepositoryImpl customerTypeRepository = new ICustomerTypeRepositoryImpl();

    @Override
    public List<TypeOfCustomer> selectAll() {
        return customerTypeRepository.selectAll();
    }
}
