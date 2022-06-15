package service;

import model.MatBang;
import model.TrangThaiMatBang;

import java.util.List;

public interface ITrangThaiMatBangService {
    List<TrangThaiMatBang> selectAll();
}
