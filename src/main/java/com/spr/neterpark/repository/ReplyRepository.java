package com.spr.neterpark.repository;

import com.spr.neterpark.entity.Replpy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReplyRepository extends JpaRepository<Replpy, Integer> {

    List<Replpy> findBybno(int bno); // 게시글에서 댓글보기

    List<Replpy> findByRno(int rno);

/*   List<Replpy> findByUserId(String userId);*/

}
