package service.impl;

import Model.Gender;
import repository.IGenderRepository;
import Model.repository.impl.IGenderRepositoryImpl;

import java.util.List;

public class IGenderServiceImpl implements IGenderRepository {
    IGenderRepositoryImpl genderService = new IGenderRepositoryImpl();


    public List<Gender> findAllGender(){
        return genderService.findAllGender();
    }
}
