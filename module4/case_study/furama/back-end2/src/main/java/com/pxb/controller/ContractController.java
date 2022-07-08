package com.pxb.controller;

import com.pxb.model.Contract;
import com.pxb.model.ContractDetail;
import com.pxb.model.Customer;
import com.pxb.service.AttachFacilityService;
import com.pxb.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    private AttachFacilityService attachFacilityService;

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
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("attachFacilities", attachFacilityService.selectAll());
        return "contract/contract";
    }

    @GetMapping("/find/{id}")
    public String findPage(@PathVariable int id, Model model){

        return "contract/contract";
    }
}
