package com.service.impl;

import com.model.Gender;
import com.repository.GenderRepository;
import com.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public List<Gender> selectAll() {
        return genderRepository.findAll();
    }
}
