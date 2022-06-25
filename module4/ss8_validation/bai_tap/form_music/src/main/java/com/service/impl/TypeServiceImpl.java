package com.service.impl;

import com.model.Type;
import com.repository.TypeRepository;
import com.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository repository;

    @Override
    public List<Type> selectAll() {
        return this.repository.selectAll();
    }
}
