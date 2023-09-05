package com.spr.neterpark.controller;


import com.spr.neterpark.entity.Board;
import com.spr.neterpark.service.BoardService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RestController
public class BoardController extends ResponseEntityExceptionHandler {

    @Autowired
    private BoardService bs;


/*    @ExceptionHandler(Exception.class)
    @GetMapping("/findall")
    public ResponseEntity<?> findAll() {
        try {
            List<Board> result = bs.getList();
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage = "에러 발생"; // 원하는 에러 메시지로 변경
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

   /* @ExceptionHandler(Exception.class)
    @PostMapping("/findid")
    public ResponseEntity<?> findByUserId(@RequestBody Board board) {
        try {
            List<Board> result = bs.getUserId(board.getUserId());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage = "에러 발생"; // 원하는 에러 메시지로 변경
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ExceptionHandler(Exception.class)
    @PostMapping("/findtitle")
    public ResponseEntity<?> findByTitle(@RequestBody Board board) {
        try {
            List<Board> result = bs.getTitle(board.getBTitle());
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            String errorMessage = "에러 발생"; // 원하는 에러 메시지로 변경
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
    @GetMapping("/findall")
    public List<Board> findAll(){
        return bs.getList();
    }

    @PostMapping("/findid")
    public List<Board> findByUserId(@RequestBody Board board){
        return bs.getUserId(board.getUserId());
    }

    @PostMapping("/findtitle")
    public List<Board> findNyTitle(@RequestBody Board board){
        return bs.getTitle(board.getBTitle());
    }

    @PostMapping("/addbo")
    public int addBoard(@RequestBody Board board){
        bs.addBoard(board);
        return 1;
    }

    @GetMapping("/detbo")
    public List<Board> detailBoard(Board board){
        return  bs.detail(board);
    }

    @DeleteMapping("/delbo")
    public void deleteBoard(@RequestBody Board board){
        bs.deleteBoard(board);
    }


}


