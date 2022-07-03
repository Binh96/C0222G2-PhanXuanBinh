package com.pxb.service.impl;

import com.pxb.model.Category;
import com.pxb.repository.CategoryRepository;
import com.pxb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> selectAll() {
        return categoryRepository.findAll();
    }
}
