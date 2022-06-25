package com.service.impl;

import com.model.Music;
import com.repository.MusicRepository;
import com.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    private MusicRepository musicRepository;

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }
}
