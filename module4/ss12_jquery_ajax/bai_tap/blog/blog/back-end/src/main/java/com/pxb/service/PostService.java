package com.pxb.service;

import com.pxb.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {
    Page<Post> selectAll(Pageable  pageable);

    Post save(Post post);
}
