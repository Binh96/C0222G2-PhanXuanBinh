package com.repository.impl;

import com.model.MedicForm;
import com.repository.MedicRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicRepositoryImpl implements MedicRepository {

    private List<MedicForm> medicForms = new ArrayList<>();


    @Override
    public void save(MedicForm medicForm) {
        medicForms.add(medicForm);
    }

    @Override
    public List<MedicForm> selectAll() {
        return medicForms;
    }

}
