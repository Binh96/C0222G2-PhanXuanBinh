package repository;

import Model.TypeOfRent;

import java.util.List;

public interface ITypeOfRentRepository {
    List<TypeOfRent> selectAll();
}
