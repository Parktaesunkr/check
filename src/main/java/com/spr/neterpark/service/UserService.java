package com.spr.neterpark.service;

import com.spr.neterpark.entity.Board;
import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.entity.User;
import com.spr.neterpark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoardService boardService;

    @Autowired
    private ReplyService replyService;

    public Optional<User> findByUserId(String userId){
        return userRepository.findById(userId);
    }


    public User add(User user){
        return userRepository.save(user);
    }

/*
    public void deleteUser(String  userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        List<Board> boardId = boardService.findByUserId();
        List<Replpy> replpy = replyService.findUserId();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Board board = optionalBoard.get();
            // 게시글과 댓글 삭제
            boardService.findAll(board);
            user.getBoard().forEach(board -> board.setUser(null));
            user.getReplpy().forEach(reply -> reply.setUser(null));
            userRepository.delete(user);
        }
    }
*/

    @Transactional
    public void deleteUser(String userId) {
        Optional<User> optionalUser = userRepository.findById(userId); // null 방지
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            userRepository.delete(user);
        }
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
