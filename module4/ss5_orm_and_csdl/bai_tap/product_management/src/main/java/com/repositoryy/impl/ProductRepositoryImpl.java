package com.repositoryy.impl;

import com.model.Product;
import com.repositoryy.ProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public List<Product> selectAll() {
        String queryStr = " select p from Product p ";
        TypedQuery<Product> products = ConnectDatabase.entityManager.createQuery(queryStr, Product.class);
        return products.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        Session session = ConnectDatabase.sessionFactory.openSession();
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
        Session session = ConnectDatabase.sessionFactory.openSession();
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
        Session session = ConnectDatabase.sessionFactory.openSession();
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
        TypedQuery<Product> query = ConnectDatabase.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> searchByName(String name) {
        String queryStr = " select p from Product p where name_product like :name";
        TypedQuery<Product> products = ConnectDatabase.entityManager.createQuery(queryStr, Product.class);
        products.setParameter("name", name);
        return products.getResultList();
    }
}
