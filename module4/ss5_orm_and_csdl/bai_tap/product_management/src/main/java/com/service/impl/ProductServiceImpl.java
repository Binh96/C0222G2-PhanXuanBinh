package com.service.impl;

import com.model.Product;
import com.service.ProductService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static{
        try{
            sessionFactory =new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        }
        catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> selectAll() {
        String queryStr = " select p from Product p ";
        TypedQuery<Product> products = entityManager.createQuery(queryStr, Product.class);
        return products.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(product);
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void updateProduct(int id, Product product) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Product origin = selectOne(id);
            origin.setNameProduct(product.getNameProduct());
            origin.setPrice(product.getPrice());
            origin.setDescProduct(product.getDescProduct());
            origin.setProducer(product.getProducer());
            session.update(origin);
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.delete(selectOne(id));
            tx.commit();
        }
        catch (HibernateException e){
            if(tx != null){
                tx.rollback();
                e.printStackTrace();
            }
        }
        finally {
            session.close();
        }
    }

    @Override
    public Product selectOne(int id) {
        String queryStr = " select c from Product as c where id = :id";
        TypedQuery<Product> query = entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> searchByName(String name) {
        String queryStr = " select p from Product p where name_product like :name";
        TypedQuery<Product> products = entityManager.createQuery(queryStr, Product.class);
        products.setParameter("name", name);
        return products.getResultList();
    }
}
