package com.controller;

import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama")
public class FuramaController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String homePage(){
        return "home";
    }

    @GetMapping("/customer")
    public String customerPage(Model model){
        model.addAttribute("customers", customerService.selectAll());
        return "listCustomer";
    }
}
