package com.controller;

import com.service.CustomerService;
import com.service.CustomerTypeService;
import com.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public String homePageCustomer(Model model){
        model.addAttribute("customers", customerService.selectAll());
        model.addAttribute("genders", genderService.selectAll());
        return "listcustomer";
    }
}
