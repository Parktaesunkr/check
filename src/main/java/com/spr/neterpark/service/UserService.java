package com.spr.neterpark.service;

import com.spr.neterpark.entity.User;
import com.spr.neterpark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserId(String userId){
        return userRepository.findByUserId(userId);
    }

    public User findByUserPwd(String userPwd){
        return userRepository.findByUserPwd(userPwd);
    }


    public User add(User user){
        return userRepository.save(user);
    }

    public User updatePwd(String userPwd){
      return   userRepository.save(userPwd);
    }

}
