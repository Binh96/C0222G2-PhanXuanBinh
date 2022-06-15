package service.impl;

import model.ToaNha;
import repository.IToaNhaRepository;
import repository.impl.ToaNhaRepositoryImpl;
import service.IToaNhaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToaNhaServiceImpl implements IToaNhaService {
    IToaNhaRepository toaNhaRepository = new ToaNhaRepositoryImpl();


    @Override
    public List<ToaNha> selectAll() {
        return toaNhaRepository.selectAll();
    }

    @Override
    public ToaNha selectByCode(String name) {
        return null;
    }

    @Override
    public List<ToaNha> selectByManyAttribute(String name, String trangThai, String matBang) {

        return toaNhaRepository.selectByManyAttribute(name, trangThai, matBang);
    }

    @Override
    public void insert(ToaNha toaNha) {
        toaNhaRepository.insert(toaNha);
    }

    @Override
    public void delete(String id) {
        toaNhaRepository.delete(id);
    }

    @Override
    public void update(String id, ToaNha toaNha) {

    }
}
