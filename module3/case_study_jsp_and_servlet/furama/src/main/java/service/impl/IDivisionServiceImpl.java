package service.impl;

import Model.Division;
import repository.IDevisionRepository;
import Model.repository.impl.IDevisionRepositoryImpl;

import java.util.List;

public class IDivisionServiceImpl implements IDevisionRepository {
    IDevisionRepositoryImpl devisionRepository = new IDevisionRepositoryImpl();

    public List<Division> findAllDivision(){
        return devisionRepository.findAllDivision();
    }
}
