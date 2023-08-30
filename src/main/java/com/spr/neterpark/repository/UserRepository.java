package com.spr.neterpark.repository;

import com.spr.neterpark.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


    public User findByUserId(String userId);

    public User findByUserPwd(String userPwd);

    public User save(String userPwd);


    public void deleteById(String userID);
}
