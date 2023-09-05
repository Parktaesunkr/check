package com.spr.neterpark.service;

import com.spr.neterpark.entity.Board;
import com.spr.neterpark.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;


    public List<Board> getUserId(String userId) {
        return boardRepository.findByUserId(userId);
    }

    public List<Board> getTitle(String bTitle){
        return boardRepository.findBybTitle(bTitle);
    }

    @Transactional
    public List<Board> getList(){
        return boardRepository.findAll();
    }

    public void addBoard(Board board){ boardRepository.save(board);}

    public void deleteBoard(Board board){boardRepository.deleteById(board.getBno());}

    public List<Board> detail(Board board){return boardRepository.findByBno(board.getBno());}
}
