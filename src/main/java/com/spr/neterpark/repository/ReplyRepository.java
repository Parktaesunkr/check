package com.spr.neterpark.repository;

import com.spr.neterpark.entity.Replpy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Replpy, Integer> {

    public List<Replpy> findBybno(int bno);

   List<Replpy> findByUserId(String userId);

}
