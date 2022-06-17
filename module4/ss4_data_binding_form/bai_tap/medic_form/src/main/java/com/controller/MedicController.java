package com.controller;

import com.model.MedicForm;
import com.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicController {
    @Autowired
    private MedicService medicService;

    @GetMapping("/medic")
    public String showForm(Model model){
        model.addAttribute("medic", new MedicForm());
        return "form";
    }

    @PostMapping("/medic")
    public String saveMedic(@ModelAttribute MedicForm medic){
        medicService.save(medic);
        return "redirect: medic";
    }

    @GetMapping("/showMedic")
    public String showListMedic(Model model){
        List<MedicForm> medicForms = medicService.selectAll();
        model.addAttribute("medicList", medicForms);
        return "list";
    }
}
