package com.pxb.service;

import com.pxb.model.Category;

import java.util.Optional;

public interface CategoryService {
    Iterable<Category> selectAll();
}
