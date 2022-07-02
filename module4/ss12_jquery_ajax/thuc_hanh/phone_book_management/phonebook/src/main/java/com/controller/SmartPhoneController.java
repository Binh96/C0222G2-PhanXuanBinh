package com.controller;


import com.model.SmartPhone;
import com.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/smartphone")
public class SmartPhoneController {
    @Autowired
    private SmartPhoneService smartphoneService;

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
}
