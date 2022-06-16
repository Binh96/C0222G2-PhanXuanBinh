package com.controller;

import com.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String show(){
        return "form";
    }

    @PostMapping("/result")
    public String calculator(@RequestParam String num1, @RequestParam String num2,
                             @RequestParam String operation, Model model){
        Integer result = calculatorService.calculator(Integer.parseInt(num1), Integer.parseInt(num2), operation);
        model.addAttribute("result", result);
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        return "form";
    }


}
