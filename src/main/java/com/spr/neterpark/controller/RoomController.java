package com.spr.neterpark.controller;

import com.spr.neterpark.entity.Room;
import com.spr.neterpark.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;


@RestController
public class RoomController {


    @Autowired
    private RoomService roomService;

    @GetMapping("/list")
    public List<Room> alllist(){return roomService.getRoom();}


    @PostMapping("/addr")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }


    @Transactional
    @DeleteMapping("/delr")
    public void deleteRoom(@RequestBody Room room){
        roomService.deleteRoom(room);
    }

}