package repository;

import model.ToaNha;

import java.util.List;

public interface IToaNhaRepository {
    List<ToaNha> selectAll();
    ToaNha selectByCode(String name);
    List<ToaNha> selectByManyAttribute(String name, String trangThai, String matBang);
    void insert(ToaNha toaNha);
    void delete(String id);
    void update(String id, ToaNha toaNha);
}
