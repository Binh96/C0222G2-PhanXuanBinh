package repository;

import Model.Position;

import java.util.List;


public interface IPositionRepository {
    List<Position> findAllPosition();
}
