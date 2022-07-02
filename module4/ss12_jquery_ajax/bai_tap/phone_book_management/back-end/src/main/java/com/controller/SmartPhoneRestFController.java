package com.controller;


import com.model.SmartPhone;
import com.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphone")
@CrossOrigin
public class SmartPhoneRestFController {

    @Autowired
    private SmartPhoneService smartPhoneService;

    @PostMapping("/create")
    public ResponseEntity<SmartPhone> createSmartphone(@RequestBody SmartPhone smartphone) {
        return new ResponseEntity<>(smartPhoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<Iterable<SmartPhone>> allPhones() {
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<SmartPhone>> deleteSmartphone(@PathVariable int id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        smartPhoneService.remove(id);
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Optional<SmartPhone>> getPhone(@PathVariable int id) {
        Optional<SmartPhone> smartphoneOptional = smartPhoneService.findById(id);
        if (!smartphoneOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(smartphoneOptional, HttpStatus.OK);
    }

    @PostMapping("/edit")
    public ResponseEntity<Iterable<SmartPhone>> updateSmartphone(@RequestBody SmartPhone smartphone) {
        smartPhoneService.save(smartphone);
        return new ResponseEntity<>(smartPhoneService.findAll(), HttpStatus.NO_CONTENT);
    }

}
