package com.spr.neterpark.service;

import com.spr.neterpark.entity.User;
import com.spr.neterpark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByUserId(String userId){
        return userRepository.findById(userId);
    }


    public User add(User user){
        return userRepository.save(user);
    }

}
