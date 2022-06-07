package service.impl;

import Model.Service;
import Model.repository.impl.IServiceRepositoryImpl;
import service.IService;

import java.util.List;

public class IServiceImpl implements IService {
    IServiceRepositoryImpl serviceRepository = new IServiceRepositoryImpl();

    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public Service findServiceByName(String name) {
        return serviceRepository.findServiceByName(name);
    }

    @Override
    public Service findServiceById(int id) {
        return serviceRepository.findServiceById(id);
    }

    @Override
    public void insertService(Service service) {
        serviceRepository.insertService(service);
    }

    @Override
    public void updateService(Integer id, Service service) {
        serviceRepository.updateService(id, service);
    }

    @Override
    public void deleteService(int id) {
        serviceRepository.deleteService(id);
    }
}
