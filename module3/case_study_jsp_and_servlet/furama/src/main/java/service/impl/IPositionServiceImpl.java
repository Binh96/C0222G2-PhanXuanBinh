package service.impl;

import Model.Position;
import repository.IPositionRepository;
import Model.repository.impl.IPositionRepositoryImpl;

import java.util.List;

public class IPositionServiceImpl implements IPositionRepository {
    IPositionRepositoryImpl positionRepository = new IPositionRepositoryImpl();

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }
}
