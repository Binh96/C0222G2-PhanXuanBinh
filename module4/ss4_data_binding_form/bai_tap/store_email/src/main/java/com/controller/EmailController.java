package com.controller;

import com.model.Email;
import com.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/form")
    public String showForm(ModelMap modelMap){
        modelMap.addAttribute("emails", new Email());
        return "form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("emails")Email email, ModelMap modelMap){
        emailService.save(email);
        modelMap.addAttribute("languages", email.getLanguages());
        modelMap.addAttribute("spam", email.isEnableSpam());
        modelMap.addAttribute("pageSize", email.getPage());
        modelMap.addAttribute("signature", email.getSignature());
        return "info";
    }

}
