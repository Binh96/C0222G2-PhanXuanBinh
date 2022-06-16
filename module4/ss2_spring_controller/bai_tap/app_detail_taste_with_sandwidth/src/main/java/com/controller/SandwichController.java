package com.controller;

import com.service.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class SandwichController {
    @Autowired
    private SandwichService sandwichService;

    @GetMapping("/sandwich")
    public String show(){
        return "menu";
    }

    @PostMapping("/save")
    public String save(@RequestParam String[] condiment, Model model){
        sandwichService.save(condiment);
//          List<String> sandwichService.getAllTaste();
        model.addAttribute("condiments", condiment);
        return "choice";
    }
}
