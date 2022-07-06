package com.pxb.service.impl;

import com.pxb.model.EducationDegree;
import com.pxb.repository.EducationDegreeRepository;
import com.pxb.service.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    private EducationDegreeRepository educationDegreeRepository;
    @Override
    public List<EducationDegree> selectAll() {
        return educationDegreeRepository.findAll();
    }
}
