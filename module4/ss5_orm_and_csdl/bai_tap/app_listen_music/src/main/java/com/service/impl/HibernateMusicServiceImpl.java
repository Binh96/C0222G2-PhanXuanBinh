package com.service.impl;

import com.model.Music;
import com.repository.MusicRepository;
import com.service.MusicService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Persister;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;

@Service
public class HibernateMusicServiceImpl implements MusicService {
    @Autowired
    private MusicRepository musicRepository;

    @Override
    public void create(Music music) {
        musicRepository.create(music);
    }

    @Override
    public List<Music> selectAll() {
        return musicRepository.selectAll();
    }

    @Override
    public void updateMusic(Music music, int id) {
        musicRepository.updateMusic(music, id);
    }

    @Override
    public Music listenMusic(int id) {
        return null;
    }

    @Override
    public void deleteMusic(int id) {
        musicRepository.deleteMusic(id);
    }

    @Override
    public Music selectMusic(int id) {
        return musicRepository.selectMusic(id);
    }
}
