package repository;

import Model.TypeOfService;

import java.util.List;

public interface IServiceTypeRepository {
    List<TypeOfService> selectAll();
}
