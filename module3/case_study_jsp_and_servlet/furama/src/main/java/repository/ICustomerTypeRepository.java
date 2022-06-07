package repository;

import Model.TypeOfCustomer;

import java.util.List;

public interface ICustomerTypeRepository {
    List<TypeOfCustomer> selectAll();
}
