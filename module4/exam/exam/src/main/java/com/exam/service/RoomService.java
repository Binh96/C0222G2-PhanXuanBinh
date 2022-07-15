package com.exam.service;

import com.exam.model.Room;

import java.util.List;

public interface RoomService {
    void updateRoom(int id);

    void updateRoomEndRent(int id);

    List<Room> selectAll();
}
