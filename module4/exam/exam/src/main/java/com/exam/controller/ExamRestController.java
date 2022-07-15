package com.exam.controller;

import com.exam.model.Contract;
import com.exam.service.ContractService;
import com.exam.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam/examRest")
public class ExamRestController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private RoomService roomService;
//
//    @GetMapping("/edit/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable int id){
//        Student student = studentService.findById(id);
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
//
//    @PutMapping("/edit")
//    public ResponseEntity<Student> getStudent(@RequestBody Student student){
//        studentService.save(student);
//        return new ResponseEntity<>(student, HttpStatus.OK);
//    }
//
    @GetMapping("/delete")
    public ResponseEntity<Contract> deleteStudent(@RequestParam int id){
        Contract contract = contractService.findById(id);
        roomService.updateRoomEndRent(id);
        contractService.delete(contract);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
