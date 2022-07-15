package com.pxb.controller;

import com.pxb.model.Customer;
import com.pxb.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/furama/customerrest")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/getcustomer")
    public ResponseEntity<List<Customer>> getCustomer(){
        List<Customer> customers = customerService.selectAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}
