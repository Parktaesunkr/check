package com.spr.neterpark.repository;

import com.spr.neterpark.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {


    List<Board> findByUserId(String userId); // 작성자로 게시글 찾기

    List<Board> findBybTitle(String bTitle); // 제목으로 게시글 찾기

    List<Board> findByBno(int bno);

}
