package com.pxb.controller;


import com.pxb.model.Facility;
import com.pxb.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/furama/serviceRest")
public class FacilityRestController {
    @Autowired
    private FacilityService facilityService;

//    @PostMapping("/create")
//    public ResponseEntity<Facility> createFacility(){
//        Facility facility = facilityService.create(facilityService);
//    }

    @GetMapping("/getfacility")
    public ResponseEntity<List<Facility>> getFacility(){
        List<Facility> facilities = facilityService.selectAll();
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }
}
