package com.service.impl;

import com.model.Music;
import com.service.StorageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StorageServiceImpl implements StorageService {

    private final static List<Music> files = new ArrayList<>();

    static{
        files.add(new Music("Nàng thơ", "Hoàng Dũng", "Indie", "https://www.youtube.com/watch?v=Zzn9-ATB9aU&list=RDH8NTALzm0F4&index=8"));
        files.add(new Music("Enemy", "Imagine Dragons x J.I.D ", "Rock ", "https://www.youtube.com/watch?v=D9G1VOjN_84&list=RDH8NTALzm0F4&index=6"));
        files.add(new Music("Chưa bao giờ", "DSK", "Rap", "https://www.youtube.com/watch?v=2xdF-amp8UI&list=RDH8NTALzm0F4&index=15"));
    }

    @Override
    public void save(Music music) {
       files.add(music);
    }

    @Override
    public List<Music> selectAll() {
        return files;
    }
}
