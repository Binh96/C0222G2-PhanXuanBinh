package repository;

import model.TrangThaiMatBang;

import java.util.List;

public interface ITrangThaiMatBangRepository {
    List<TrangThaiMatBang> selectAll();
}
