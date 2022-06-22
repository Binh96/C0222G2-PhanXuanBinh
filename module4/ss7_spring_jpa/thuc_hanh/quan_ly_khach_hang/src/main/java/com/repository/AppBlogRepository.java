package com.repository;

import com.model.AppBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppBlogRepository extends JpaRepository<AppBlog, Integer> {
}
