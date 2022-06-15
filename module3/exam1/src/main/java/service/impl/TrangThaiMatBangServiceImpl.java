package service.impl;

import model.TrangThaiMatBang;
import repository.ITrangThaiMatBangRepository;
import repository.impl.TrangThaiMatBangRepositoryImpl;
import service.ITrangThaiMatBangService;

import java.util.List;

public class TrangThaiMatBangServiceImpl implements ITrangThaiMatBangService {
    ITrangThaiMatBangRepository trangThaiMatBangRepository = new TrangThaiMatBangRepositoryImpl();

    @Override
    public List<TrangThaiMatBang> selectAll() {
        return trangThaiMatBangRepository.selectAll();
    }
}
