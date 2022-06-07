package service.impl;

import Model.repository.impl.IFuramaRepositoryImpl;
import service.IFuramaService;

import java.util.List;

public class IFuramaServiceImpl implements IFuramaService {
    IFuramaRepositoryImpl furamaRepository = new IFuramaRepositoryImpl();

    @Override
    public <E> List<E> findByName(String name) {
        return furamaRepository.findByName(name);
    }
}
