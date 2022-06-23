package com.service;

import com.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    void save(Post post);
    void delete(int id);
//    List<Post> findByTitle(String title);
    Post findById(int id);
    Page<Post> findByTitle(String title, Pageable pageable);
    Page<Post> getAll(Pageable pageable);
    Page<Post> getAllByName(String title, Pageable pageable);
}
