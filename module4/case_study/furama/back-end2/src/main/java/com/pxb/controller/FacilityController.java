package com.pxb.controller;

import com.pxb.model.Facility;
import com.pxb.service.FacilityService;
import com.pxb.service.FacilityTypeService;
import com.pxb.service.RentTypeService;
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
@RequestMapping("/furama/service")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;
    @Autowired
    private FacilityTypeService facilityTypeService;

    @Autowired
    private RentTypeService rentTypeService;

    @GetMapping("")
    public String servicePage(@PageableDefault(value = 5)Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size, Model model){
        Page<Facility> facilities = facilityService.selectAll(pageable);
        int curPage = page.orElse(1);
        int pageSize = size.orElse(5);
        int totalPages = facilities.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("facilities", facilities);
        return "service/list-service";
    }

    @GetMapping("/create")
    public String serviceCreatePage(Model model){
        model.addAttribute("facility", new Facility());
        model.addAttribute("typeServices", facilityTypeService.selectAll());
        model.addAttribute("typeRents", rentTypeService.selectAll());
        return "service/create-service";
    }

    @PostMapping("/create")
    public String serviceCreatePage(@ModelAttribute Facility facility, Model model, RedirectAttributes redirectAttributes){
        try{
            if(facilityService.findById(facility.getId()) != null){
                redirectAttributes.addAttribute("error", "This service have been here! Try again or out...");
                return "service/create-service";
            }
            facilityService.create(facility);
            return "redirect:/furama/service";
        }
        catch (Exception e){
            return "404error";
        }
    }

    @GetMapping("/{id}")
    public String serviceDeletePage(@PathVariable int id, Model model){
        System.out.println(id);
        Facility facility = facilityService.findById(id);
        facilityService.deleteById(facility);
        return "redirect:/furama/service";
    }
}
