package service;

import model.ToaNha;

import java.util.List;
import java.util.Map;

public interface IToaNhaService {

    List<ToaNha> selectAll();
    ToaNha selectByCode(String name);
    List<ToaNha> selectByManyAttribute(String name, String trangThai, String matBang);
    void insert(ToaNha toaNha);
    void delete(String id);
    void update(String id, ToaNha toaNha);

}
