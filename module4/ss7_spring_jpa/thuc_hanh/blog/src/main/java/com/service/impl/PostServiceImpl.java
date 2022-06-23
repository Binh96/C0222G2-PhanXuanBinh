package com.service.impl;


import com.model.Post;
import com.repository.PostRepository;
import com.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public void save(Post post) {
        this.postRepository.save(post);
    }

    @Override
    public void delete(int id) {
        this.postRepository.delete(findById(id));
    }


    @Override
    public Post findById(int id) {
        return this.postRepository.findById(id);
    }

    @Override
    public Page<Post> findByTitle(String title, Pageable pageable) {
        return this.postRepository.findByTitle(title, pageable);
    }

    @Override
    public Page<Post> getAll(Pageable pageable) {
        return this.postRepository.getAll(pageable);
    }

    @Override
    public Page<Post> getAllByName(String title, Pageable pageable) {
        return this.postRepository.getAllByTitle(title, pageable);
    }

}
