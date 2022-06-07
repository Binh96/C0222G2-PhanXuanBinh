package repository;

import Model.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> selectAllService();
    Service findServiceByName(String name);
    Service findServiceById(int id);
    void insertService(Service service);
    void updateService(Integer id, Service service);
    void deleteService(int id);
}
