package com.controller;

import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/furama/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
}
