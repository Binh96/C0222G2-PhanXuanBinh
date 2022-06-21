package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("customers", customerService.findAll());
        return "list";
    }

    @GetMapping("/{id}/edit")
    public String updateCustomer(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findOne(id));
        return "info";
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute Customer customer){
        customerService.save(customer);
        return "rediect: /customer";
    }
}
