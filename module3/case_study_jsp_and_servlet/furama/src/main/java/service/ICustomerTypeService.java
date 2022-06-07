package service;

import Model.TypeOfCustomer;

import java.util.List;

public interface ICustomerTypeService {
    List<TypeOfCustomer> selectAll();
}
