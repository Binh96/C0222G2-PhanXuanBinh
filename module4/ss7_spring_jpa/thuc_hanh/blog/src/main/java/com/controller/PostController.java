package com.controller;

import com.model.Post;
import com.service.CatagoryService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CatagoryService catagoryService;


    @GetMapping("")
    public String homePage(Model model, @PageableDefault(value = 4)Pageable pageable,
                           @RequestParam Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("posts", this.postService.getAllByName('%'+keywordVal+'%', pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "home";
    }

    @GetMapping("/create")
    public String createPage(Model model){
        model.addAttribute("post", new Post());
        model.addAttribute("catagoryList", this.catagoryService.selectAll());
        return "create";
    }

    @PostMapping("/create")
    public String createPost(@ModelAttribute Post post){
        Date date = new Date();
        Post newPost = new Post(post.getTitle(), post.getContent(), post.getImgPath(),post.getDescription(), date);
        postService.save(newPost);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String deletePost(@RequestParam int id, @ModelAttribute Post post){
        postService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("{id}/detail")
    public String detailPost(@PathVariable int id, Model model){
        model.addAttribute("post", postService.findById(id));
        return "detail";
    }
}
