package com.service.impl;

import com.model.Sandwich;
import com.service.SandwichService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SandwichServiceImpl implements SandwichService {
    Sandwich sandwich = new Sandwich();

    @Override
    public void save(String[] taste) {
        List<String> temp = new ArrayList<>(Arrays.asList(taste));
        sandwich.setTaste(temp);
    }

    @Override
    public List<String> getAllTaste() {
        return sandwich.getTaste();
    }


}
