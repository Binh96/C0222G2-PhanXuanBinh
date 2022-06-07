package service.impl;

import Model.TypeOfRent;
import Model.repository.impl.ITypeOfRentRepositoryImpl;
import service.ITypeOFRentService;

import java.util.List;

public class ITypeOfRentServiceImpl implements ITypeOFRentService {
    ITypeOfRentRepositoryImpl typeOfRentRepository = new ITypeOfRentRepositoryImpl();

    @Override
    public List<TypeOfRent> selectAll() {
        return typeOfRentRepository.selectAll();
    }
}
