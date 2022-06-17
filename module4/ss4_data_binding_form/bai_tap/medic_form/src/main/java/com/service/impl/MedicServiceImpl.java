package com.service.impl;

import com.model.MedicForm;
import com.repository.MedicRepository;
import com.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicServiceImpl implements MedicService {
    @Autowired
    private MedicRepository medicRepository;

    @Override
    public void save(MedicForm medicForm) {
        medicRepository.save(medicForm);
    }

    @Override
    public List<MedicForm> selectAll() {
        return medicRepository.selectAll();
    }
}
