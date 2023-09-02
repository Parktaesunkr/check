package com.spr.neterpark.repository;

import com.spr.neterpark.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {


    public List<Board> deleteByuserId(String userId); // 작성자로 글삭제(Member삭제시 필요할 것 같아서 제작)

    List<Board> findByUserId(String userId); // 작성자로 게시글 찾기
}
