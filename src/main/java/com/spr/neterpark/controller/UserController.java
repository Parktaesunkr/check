package com.spr.neterpark.controller;

import com.spr.neterpark.entity.User;
import com.spr.neterpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public int loginUser(@RequestBody User user) {
        User existingUser = userService.findByUserId(user.getUserId());

        if (existingUser != null && existingUser.getUserPwd().equals(user.getUserPwd())) {
            return 1; // 로그인 성공
        } else {
            return -1; // 로그인 실패
        }
    }


    @PostMapping
    public void addUser(User user){
        userService.add(user);
    }



}
