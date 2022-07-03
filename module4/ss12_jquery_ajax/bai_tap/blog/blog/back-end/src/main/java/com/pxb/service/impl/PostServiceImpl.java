package com.pxb.service.impl;


import com.pxb.model.Post;
import com.pxb.repository.PostRepository;
import com.pxb.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> selectAll(Pageable pageable) {
        return postRepository.selectAll(pageable);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
