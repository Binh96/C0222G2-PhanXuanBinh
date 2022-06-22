package com.repository;

import com.model.Blog;

import java.util.List;

public interface BlogRepository {

    List<Blog> selectAll();

    void insert(Blog blog);

    void delete(int id);

    void update(Blog blog);

    Blog selectOne(int id);
}
