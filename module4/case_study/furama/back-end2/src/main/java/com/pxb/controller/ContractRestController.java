package com.pxb.controller;

import com.pxb.dto.ContractDto;
import com.pxb.model.AttachFacility;
import com.pxb.model.Contract;
import com.pxb.model.ContractDetail;
import com.pxb.service.AttachFacilityService;
import com.pxb.service.ContractDetailService;
import com.pxb.service.ContractService;
import com.pxb.service.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/furama/contractrest")
public class ContractRestController {

    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachFacilityService attachFacilityService;

    @Autowired
    private FacilityService facilityService;


    @GetMapping("/find/{id}")
    public ResponseEntity<List<ContractDetail>> findServeContract(@PathVariable int id){
        List<ContractDetail> contractDetails = contractDetailService.selectById(id);
        return new ResponseEntity<>(contractDetails, HttpStatus.OK);
    }

    @PostMapping("/create_contract_detail")
    public ResponseEntity<ContractDetail> createContractDetail(@RequestBody ContractDetail contractDetail){
        ContractDetail newContractDetail = contractDetailService.saveContractDetail(contractDetail);
        return new ResponseEntity<>(newContractDetail, HttpStatus.OK);
    }

    @GetMapping("/get_attach_forcontractdetail")
    public ResponseEntity<List<AttachFacility>> createContractDetail(){
        List<AttachFacility> attachFacilities = attachFacilityService.selectAll();
        return new ResponseEntity<>(attachFacilities, HttpStatus.OK);
    }

    @GetMapping("/get_total_forcontractdetail")
    public ResponseEntity<Page<ContractDto>> totalPayContract(@PageableDefault(value = 5)Pageable pageable){
        Page<ContractDto> contractDtos = contractService.getTotal(pageable);
        return new ResponseEntity<>(contractDtos, HttpStatus.OK);
    }


}
