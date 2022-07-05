package com.pxb.controller;


import com.pxb.model.Post;
import com.pxb.service.CategoryService;
import com.pxb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
@CrossOrigin
public class BlogRestController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/post")
    public ResponseEntity<Page<Post>> getPost( @RequestParam(value = "size", required = false) Optional<Integer> pageSize,
                                               @RequestParam(value = "page", required = false) Optional<Integer> pageNumber){
        PageRequest pageRequest = PageRequest.of(pageNumber.orElse(0), pageSize.orElse(2));
        return new ResponseEntity<>(postService.selectAll(pageRequest),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        post.setDatePost(new Date());
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }
}
