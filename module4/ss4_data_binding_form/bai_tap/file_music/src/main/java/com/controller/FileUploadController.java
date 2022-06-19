package com.controller;

import com.model.Music;
import com.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/file")
public class FileUploadController {
    @Autowired
    private StorageService storageService;

    @GetMapping("")
    public String homepage(Model model) {
        model.addAttribute("filePath", new Music());
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@ModelAttribute Music filePath){
        storageService.save(filePath);
        return "redirect: /file";
    }

    @GetMapping("/list")
    public String viewList(Model model){
        List<Music> musicList =storageService.selectAll();
        model.addAttribute("musics", musicList);
        return "list";
    }
}
