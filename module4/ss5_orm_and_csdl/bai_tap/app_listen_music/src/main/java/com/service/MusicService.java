package com.service;

import com.model.Music;

import java.util.List;

public interface MusicService {
    void create(Music music);

    List<Music> selectAll();

    void updateMusic(Music music, int id);

    Music listenMusic(int id);

    void deleteMusic(int id);

    Music selectMusic(int id);

}
