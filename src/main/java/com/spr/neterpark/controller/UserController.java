package com.spr.neterpark.controller;

import com.spr.neterpark.entity.Board;
import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.entity.User;
import com.spr.neterpark.service.BoardService;
import com.spr.neterpark.service.ReplyService;
import com.spr.neterpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;
    

    @PostMapping("/login")
    public int login(@RequestBody User user){
        Optional<User> user1 = userService.findByUserId(user.getUserId());
        if (user1.isPresent()) {
            User existingUser = user1.get();

            if (existingUser.getUserPwd() != null && existingUser.getUserPwd().equals(user.getUserPwd())) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }


    @PostMapping("/signup")
    public int addUser(@RequestBody User user){
        userService.add(user);
        return 1; // 확인용
    }

   /* @DeleteMapping("/delete")
    public int deleteUser(@RequestBody User user){
        if(user != null) {
            List<Board> board = boardService.findAll();
            boardService.deleteBoard(board.get(user));
            userService.delete(user);
            return 1; // 확인용
        }else {
            return -1;
        }
    }*/

    @Transactional
    @DeleteMapping("/delete")
    public int deleteUser(@RequestBody User user) {
            // 사용자 삭제
        if (user != null) {
            userService.deleteUser(user.getUserId());
            return 1; // 확인용
        }else {
            return -1;
        }
    }

    @PutMapping("/changePwd")
    public int changePwd(@RequestBody User user){
        if (userService.changePwd(user.getUserId(), user.getUserPwd()) == 1) {
            userService.changePwd(user.getUserId(), user.getUserPwd());
            return 1;
        }else {
            return -1;
        }

    }



}
