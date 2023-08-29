package com.spr.neterpark.controller;

import com.spr.neterpark.entity.User;
import com.spr.neterpark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository us;

    @PostMapping("/login")
    private int loginUser(User user){
        String resultI ="";
        String resultP = "";
        if(resultI == user.getUserId()) {
            if ( resultP == user.getUserPwd()){
                return 1;
            }else{
                return -1;
            }
        } else {
            return -1;
        }
    }

}
