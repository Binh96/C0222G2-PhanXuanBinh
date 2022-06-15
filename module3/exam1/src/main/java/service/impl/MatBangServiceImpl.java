package service.impl;

import model.MatBang;
import repository.IMatBangRepository;
import repository.impl.MatBangRepositoryImpl;
import service.IMatBangService;

import java.util.List;

public class MatBangServiceImpl implements IMatBangService {
    IMatBangRepository matBangRepository = new MatBangRepositoryImpl();

    @Override
    public List<MatBang> selectAll() {
        return matBangRepository.selectAll();
    }
}
