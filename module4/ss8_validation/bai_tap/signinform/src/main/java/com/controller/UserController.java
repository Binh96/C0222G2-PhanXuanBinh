package com.controller;


import com.dto.UserDTO;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("userDto", new UserDTO());
        return "index";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute @Validated UserDTO userDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){


        if(bindingResult.hasErrors()){
            return "index";
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("msg", "Success addition users");
        return "redirect:/user";
    }
}
