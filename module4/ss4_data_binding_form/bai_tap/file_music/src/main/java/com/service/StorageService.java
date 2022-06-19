package com.service;

import com.model.Music;

import java.util.List;

public interface StorageService {
    void save(Music music);
    List<Music> selectAll();
}
