package com.service.impl;

import com.model.Blog;
import com.repository.BlogRepository;
import com.service.BlogService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> selectAll() {
        return blogRepository.selectAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        try{
            blogRepository.insert(blog);
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBlog(int id) {
        try {
            blogRepository.delete(id);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateBlog(Blog blog) {
        try {
            blogRepository.update(blog);
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public Blog selectOne(int id) {
        return blogRepository.selectOne(id);
    }
}
