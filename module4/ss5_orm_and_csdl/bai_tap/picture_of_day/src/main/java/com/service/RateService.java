package com.service;

import com.model.Rate;

import java.util.List;

public interface RateService {
    List<Rate> selectAll();

    void insert(Rate rate);

    void update(Rate rate);
}
