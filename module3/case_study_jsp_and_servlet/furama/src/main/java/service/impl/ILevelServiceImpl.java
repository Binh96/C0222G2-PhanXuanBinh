package service.impl;

import Model.Level;
import repository.ILevelRepository;
import Model.repository.impl.ILevelRepositoryImpl;

import java.util.List;

public class ILevelServiceImpl implements ILevelRepository {
    ILevelRepositoryImpl levelRepository = new ILevelRepositoryImpl();

    @Override
    public List<Level> findAllLevel() {
        return levelRepository.findAllLevel();
    }
}
