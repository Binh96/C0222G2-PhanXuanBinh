package com.controller;


import com.dto.MusicDto;
import com.model.Music;
import com.service.MusicService;
import com.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import javax.xml.ws.Action;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicService musicService;
    @Autowired
    private TypeService typeService;

    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("music", new MusicDto());
        model.addAttribute("typeOfMusic", typeService.selectAll());
        return "index";
    }

    @PostMapping("/create")
    public String homePage(@Valid @ModelAttribute("music") MusicDto music, BindingResult bindingResult,
                           RedirectAttributes redirectAttributes, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("typeOfMusic", typeService.selectAll());
            return "index";
        }
        Music music1 = new Music();
        BeanUtils.copyProperties(music, music1);
        this.musicService.save(music1);
        redirectAttributes.addFlashAttribute("msg", "success create music");
        return "redirect:/music";
    }
}
