package com.pxb.controller;

import com.pxb.dto.ContractDto;
import com.pxb.model.Contract;
import com.pxb.model.ContractDetail;
import com.pxb.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/furama/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;

    @Autowired
    private ContractDetailService contractDetailService;

    @Autowired
    private AttachFacilityService attachFacilityService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    public String servicePage(@PageableDefault(value = 5) Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size, Model model){
        Page<Contract> contracts = contractService.selectAll(pageable);

        if(contracts.isEmpty()){
            model.addAttribute("error", "No data available");
        }
        int currPage = page.orElse(1);
        int pageSize = size.orElse(5);
        int totalPages = contracts.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("contracts", contracts);
        model.addAttribute("contractDetail1", contractDetailService.selectAll());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacilities", attachFacilityService.selectAll());
        return "contract/contract";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("contractDto", new ContractDto());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("employees", employeeService.selectAll());
        model.addAttribute("customers", customerService.selectAll());
        model.addAttribute("facilities", facilityService.selectAll());
        model.addAttribute("attachFacilites", attachFacilityService.selectAll());
        return "contract/createcontract";
    }


    @PostMapping("/create")
    public String createPage(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult,
                             @ModelAttribute ContractDetail contractDetail){
        if(bindingResult.hasErrors()){
            return "contract/createcontract";
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contractService.create(contract);
        if(contractDetail.getContract() != null){
            contractDetail.setContract(contract);
            contractDetailService.saveContractDetail(contractDetail);
        }
        return "redirect:/furama/contract";
    }

    @GetMapping("/find/{id}")
    public String findPage(@PathVariable int id, Model model){

        return "contract/contract";
    }
}
