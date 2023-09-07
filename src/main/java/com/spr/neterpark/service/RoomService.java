package com.spr.neterpark.service;

import com.spr.neterpark.entity.Room;
import com.spr.neterpark.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public List<Room> getRoom(){return roomRepository.findAll();}

    public Room addRoom(Room room){return roomRepository.save(room);}

    public void deleteRoom(Room room) {
        roomRepository.deleteByRmno(room.getRmno());
    }


}
