package com.service.impl;

import com.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public Integer calculator(Integer num1, Integer num2, String operation) {
        Integer result = 0;
        switch (operation){
            case "add": result = num1 + num2;
                break;
            case "sub": result = num1 - num2;
                break;
            case "mul": result = num1 * num2;
                break;
            case "div":{
                try{
                    result = num1 / num2;
                }catch (ArithmeticException e){
                    e.printStackTrace();
                }
                break;
            }
        }
        return  result;
    }
}
