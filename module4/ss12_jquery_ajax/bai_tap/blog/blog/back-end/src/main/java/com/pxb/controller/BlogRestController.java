package com.pxb.controller;


import com.pxb.model.Post;
import com.pxb.service.CategoryService;
import com.pxb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/blog")
@CrossOrigin
public class BlogRestController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/post")
    public ResponseEntity<Page<Post>> getPost(@PageableDefault(value = 2)Pageable pageable){
        Page<Post> listPost = postService.selectAll(pageable);
        if(listPost != null){
            return new ResponseEntity<>(listPost, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        post.setDatePost(new Date());
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
}
