package com.pxb.backendexam.controller;

import com.pxb.backendexam.model.Consignment;
import com.pxb.backendexam.model.Product;
import com.pxb.backendexam.service.ConsignmentService;
import com.pxb.backendexam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsignmentRestController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ConsignmentService consignmentService;

    @GetMapping("/consignment")
    public ResponseEntity<List<Consignment>> getConsignment(){
        List<Consignment> consignmentList = consignmentService.getAll();
        System.out.println(consignmentList.get(0).getProduct());
        return new ResponseEntity<>(consignmentList, HttpStatus.OK);
    }

    @GetMapping("/getConsignment")
    public ResponseEntity<Consignment> getConsignmentById(@RequestParam int id){
        Consignment consignment = consignmentService.findById(id);
        return new ResponseEntity<>(consignment, HttpStatus.OK);
    }

    @GetMapping("/getConsignmentByAll")
    public ResponseEntity<List<Consignment>> getConsignmentByName(@RequestBody Consignment consignment){
        System.out.println(consignment.getProduct().getNameProduct());
        List<Consignment> consignments = consignmentService.findByAll(consignment.getId()r);
        return new ResponseEntity<>(consignments, HttpStatus.OK);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProduct(){
        List<Product> productList = productService.getAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/consignment")
    public ResponseEntity<Consignment> createConsignment(@RequestBody Consignment consignment){
        consignmentService.createConsignment(consignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping   ("/updateConsignment")
    public ResponseEntity<Consignment> editConsignment(@RequestBody Consignment consignment){
        consignmentService.editConsignment(consignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/consignment")
    public ResponseEntity<Consignment> deleteConsignmentById(@RequestParam int id){
        consignmentService.deleteConsignment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
