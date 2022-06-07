package service.impl;

import Model.TypeOfService;
import Model.repository.impl.IServiceTypeRepositoryImpl;
import service.ITypeOfService;

import java.util.List;

public class ITypeOfServiceImpl implements ITypeOfService {
    IServiceTypeRepositoryImpl iServiceTypeRepository = new IServiceTypeRepositoryImpl();

    @Override
    public List<TypeOfService> selectAll() {
        return iServiceTypeRepository.selectAll();
    }
}
