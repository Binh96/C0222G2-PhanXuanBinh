package com.exam.service.impl;

import com.exam.model.Room;
import com.exam.repository.RoomRepository;
import com.exam.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;



    @Override
    public void updateRoom(int id) {
        roomRepository.updateRoom(id);
    }

    @Override
    public void updateRoomEndRent(int id) {
        roomRepository.updateRoomEndRent(id);
    }

    @Override
    public List<Room> selectAll() {
        return roomRepository.selectAll();
    }
}
