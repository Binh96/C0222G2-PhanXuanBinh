package com.repository.impl;

import com.model.Blog;
import com.repository.BlogRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {


    @Override
    public List<Blog> selectAll() {
        String queryStr = " select b from Blog b ";
        TypedQuery<Blog> query = ConnectDatabase.entityManager.createQuery(queryStr, Blog.class);
        return query.getResultList();
    }

    @Override
    public void insert(Blog blog) {
        EntityTransaction entityTransaction = ConnectDatabase.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectDatabase.entityManager.persist(blog);
        entityTransaction.commit();
    }

    @Override
    public void delete(int id) {
        ConnectDatabase.entityManager.remove(selectOne(id));
    }

    @Override
    public void update(Blog blog) {
        EntityTransaction entityTransaction = ConnectDatabase.entityManager.getTransaction();
        entityTransaction.begin();
        ConnectDatabase.entityManager.merge(blog);
        entityTransaction.commit();
    }

    @Override
    public Blog selectOne(int id) {
        return ConnectDatabase.entityManager.find(Blog.class, id);
    }
}
