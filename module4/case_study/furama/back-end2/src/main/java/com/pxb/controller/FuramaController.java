package com.pxb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class FuramaController {

    @GetMapping("")
    public String homePage(){
        return "home";
    }

    @GetMapping("/customer")
    public String customerPage(){
        return "/customer/list-customer";
    }

    @GetMapping("/employee")
    public String employeePage(){
        return "/employee/list-employee";
    }

}
