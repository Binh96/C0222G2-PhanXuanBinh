package com.service;

import com.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAll();

    void saveBlog(Blog blog);

    void deleteBlog(int id);

    void updateBlog(Blog blog);

    Blog selectOne(int id);
}
