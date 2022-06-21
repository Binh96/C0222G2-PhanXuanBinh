package com.controller;

import com.model.Music;
import com.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/song")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songs", musicService.selectAll());
        return "list";
    }

    @GetMapping("/create")
    public String createSong(Model model){
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String createSong(@ModelAttribute Music music){
        musicService.create(music);
        return "redirect: /song";
    }

    @GetMapping("{id}/edit")
    public String editSong(@PathVariable int id, Model model){
        model.addAttribute("music", musicService.selectMusic(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editSong(@ModelAttribute Music music){
        System.out.println(music.getId());
        System.out.println(music.getTypeSong());
        System.out.println(music.getNameSinger());
        System.out.println(music.getNameSong());
        musicService.updateMusic(music, music.getId());
        return "redirect: /song";
    }

    @GetMapping("{id}/delete")
    public String deleteSong(@PathVariable int id, Model model){
        model.addAttribute("music", musicService.selectMusic(id));
        return "delete";
    }

    @GetMapping("/delete")
    public String deleteSong(@ModelAttribute Music music){
        musicService.deleteMusic(music.getId());
        return "redirect: /song";
    }

}
