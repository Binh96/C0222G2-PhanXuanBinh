package com.repository.impl;

import com.model.Music;
import com.repository.MusicRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements MusicRepository {

    @Override
    public void create(Music music) {
        Session session = ConnectDatabase.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(music);
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
    public List<Music> selectAll() {
        String queryStr = " select c from Music as c";
        TypedQuery<Music> query = ConnectDatabase.entityManager.createQuery(queryStr, Music.class);
        return query.getResultList();
    }

    @Override
    public void updateMusic(Music music, int id) {
        Session session = ConnectDatabase.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Music origin = selectMusic(id);
            origin.setNameSong(music.getNameSong());
            origin.setNameSinger(music.getNameSinger());
            origin.setTypeSong(music.getTypeSong());
            origin.setPathSong(music.getPathSong());
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
    public Music listenMusic(int id) {
        return null;
    }

    @Override
    public void deleteMusic(int id) {
        Session session = ConnectDatabase.sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Music origin = selectMusic(id);
            session.delete(origin);
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
    public Music selectMusic(int id) {
        String queryStr = " select c from Music as c where id = :id";
        TypedQuery<Music> query = ConnectDatabase.entityManager.createQuery(queryStr, Music.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
