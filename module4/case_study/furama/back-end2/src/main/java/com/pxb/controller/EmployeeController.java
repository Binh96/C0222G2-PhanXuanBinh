package com.pxb.controller;

import com.pxb.model.Customer;
import com.pxb.model.Employee;
import com.pxb.model.Facility;
import com.pxb.service.DivisionService;
import com.pxb.service.EducationDegreeService;
import com.pxb.service.EmployeeService;
import com.pxb.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/furama/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @Autowired
    private PositionService positionService;

    @GetMapping("")
    public String employeePage(@PageableDefault(value = 5) Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size, Model model){
        Page<Employee> employees = employeeService.selectAll(pageable);
        if(employees.isEmpty()){
            model.addAttribute("error", "No data available");
        }
        int currPage = page.orElse(1);
        int pageSize = size.orElse(5);
        int totalPages = employees.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("employees", employees);
        model.addAttribute("employeeEdit", new Employee());
        model.addAttribute("employee", new Employee());
        model.addAttribute("positions", positionService.selectAll());
        model.addAttribute("educationDegrees", educationDegreeService.selectAll());
        model.addAttribute("divisions", divisionService.selectAll());
        return "employee/list-employee";
    }

    @PostMapping("/create")
    public String serviceCreatePage(@ModelAttribute Employee employee, Model model, RedirectAttributes redirectAttributes){
        try{
            if(employeeService.findById(employee.getId()) != null){
                redirectAttributes.addAttribute("error", "This service have been here! Try again or out...");
                return "employee/list-service";
            }
            employeeService.create(employee);
            return "redirect:/furama/service";
        }
        catch (Exception e){
            return "404error";
        }
    }
}
