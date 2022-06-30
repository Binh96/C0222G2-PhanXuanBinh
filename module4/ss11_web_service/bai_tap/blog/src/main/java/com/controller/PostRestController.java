package com.controller;

import com.model.Catagory;
import com.model.Post;
import com.service.CatagoryService;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class PostRestController {

    @Autowired
    private PostService postService;

    @Autowired
    private CatagoryService catagoryService;

    @GetMapping("/list")
    public ResponseEntity<Page<Post>> listPost(@PageableDefault(value = 2)Pageable pageable){
        Page<Post> posts = postService.getAll(pageable);
        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<Catagory>> categoryList(){
        List<Catagory> categories = catagoryService.selectAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}/detail2")
    public ResponseEntity<Post> postRestFul(@PathVariable int id){
        Post post = postService.findById(id);
        if(post == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
}
