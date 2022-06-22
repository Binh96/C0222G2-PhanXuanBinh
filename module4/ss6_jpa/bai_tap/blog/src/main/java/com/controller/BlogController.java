package com.controller;

import com.model.Blog;
import com.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/blog")
public class BlogController{

    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public String showBlog(Model model){
        model.addAttribute("blogs", blogService.selectAll());
        return "home";
    }

    @GetMapping("/create")
    public String createBlog(Model model){
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog){
        Date date = new Date();
        Blog blog1 = new Blog(blog.getTitle(), blog.getContent(), date, blog.getImg());
        blogService.saveBlog(blog1);
        return "redirect: /blog";
    }

    @GetMapping("{id}/detail")
    public String detailBlog(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.selectOne(id));
        return "detail";
    }

    @GetMapping("{id}/delete")
    public String deleteBlog(@PathVariable int id){
        blogService.deleteBlog(id);
        return "redirect: detail";
    }

    @GetMapping("{id}/edit")
    public String updateBlog(@PathVariable int id, Model model){
        model.addAttribute("blog", blogService.selectOne(id));
        return "update";
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Blog blog){
        Date date = new Date();
        Blog blog1 = new Blog(blog.getId(), blog.getTitle(), blog.getContent(), date, blog.getImg());
        blogService.updateBlog(blog1);
        return "redirect: /blog";
    }
}
