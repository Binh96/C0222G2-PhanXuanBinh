package com.pxb.controller;

import com.pxb.dto.CustomerDto;
import com.pxb.model.Customer;
import com.pxb.model.Facility;
import com.pxb.service.CustomerService;
import com.pxb.service.CustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/furama/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public String customerPage(@PageableDefault(value = 5) Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size, Model model,
                              @RequestParam Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        Page<Customer> customers = this.customerService.selectByName(pageable, '%'+keywordVal+'%');
        if(customers.isEmpty()){
            model.addAttribute("error", "No data available");
        }
        int currPage = page.orElse(1);
        int pageSize = size.orElse(5);
        int totalPages = customers.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("customers", customers);
        return "customer/list-customer";
    }

    @GetMapping("/create")
    public String customerCreatePage(Model model){
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypes", customerTypeService.selectAll());
        return "customer/create-customer";
    }

    @PostMapping("/create")
    public String customerCreatePage(@Valid @ModelAttribute CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes){
        try{
            if(bindingResult.hasErrors()){
                return "customer/create-customer";
            }
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.create(customer);
            return "redirect:/furama/customer";
        }
        catch (Exception e){
            return "404error";
        }
    }

    @GetMapping("/edit")
    public String customerEditPage(@RequestParam int id, Model model){
        Customer customer = customerService.findById(id);
        try{
            model.addAttribute("customer", customer);
            model.addAttribute("customerTypes", customerTypeService.selectAll());
            return "customer/edit-customer";
        }
        catch (Exception e){
            return "404error";
        }
    }

    @PostMapping("/edit")
    public String customerEditPage(@ModelAttribute Customer customer, Model model, RedirectAttributes redirectAttributes){
        try{
            customerService.edit(customer);
            return "redirect:/furama/customer";
        }
        catch (Exception e){
            return "404error";
        }
    }

    @GetMapping("/{id}")
    public String customerDeletePage(@PathVariable int id, Model model){
        customerService.deleteById(id);
        return "redirect:/furama/customer";
    }
}
