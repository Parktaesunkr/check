package com.spr.neterpark.controller;

import com.spr.neterpark.entity.User;
import com.spr.neterpark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    

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
    public void addUser(User user){
        userService.add(user);
    }





}
