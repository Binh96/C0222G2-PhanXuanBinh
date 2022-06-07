package service;

import Model.Service;

import java.util.List;

public interface IService {
    List<Service> selectAllService();
    Service findServiceByName(String name);
    Service findServiceById(int id);
    void insertService(Service service);
    void updateService(Integer id, Service service);
    void deleteService(int id);
}
