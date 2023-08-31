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

    public void delete(User userId){
        userRepository.delete(userId);
    }

/*    public void changePwd1(String userId, String userPwd){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setUserPwd(userPwd); // 비밀번호 암호화 없이 변경
            userRepository.save(user);
        }
    }*/

    public int changePwd(String userId, String userPwd) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserPwd(userPwd);
            userRepository.save(user);
            return 1;
        } else {
         return -1;
        }
    }
}
