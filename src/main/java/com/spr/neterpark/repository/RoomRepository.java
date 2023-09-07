package com.spr.neterpark.repository;

import com.spr.neterpark.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, String> {
    void deleteByRmno(int rmno);

}
