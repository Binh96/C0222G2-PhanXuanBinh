package com.pxb.service.impl;

import com.pxb.model.Position;
import com.pxb.repository.PositionRepository;
import com.pxb.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionRepository positionRepository;
    @Override
    public List<Position> selectAll() {
        return positionRepository.findAll();
    }
}
