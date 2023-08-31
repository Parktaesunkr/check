package com.spr.neterpark.controller;

import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService rs;


    @PostMapping("/lire")
    public List<Replpy> showReply(@RequestBody Replpy replpy){
        if(replpy.getUser() != null) {
           return rs.listReply(replpy);
        }else{
         return null;
        }
    }

    @PostMapping("/upre")
    public int updateReply(@RequestBody Replpy replpy){
        if (replpy.getUserId() != null) {
            // 댓글의 작성자 아이디가 null이 아닌 경우
            String Content = replpy.getRContent(); // 댓글 내용 가져오기
            if (Content != null) {
                replpy.setRContent(Content); // 댓글 내용 업데이트
                rs.updateReply(replpy); // 변경된 내용을 저장
                return 1; // 성공적으로 업데이트한 경우
            } else {
                return -2; // 댓글 내용이 null인 경우
            }
        } else {
            return -1; // 댓글 작성자 아이디가 null인 경우
        }
    }


    @PostMapping("/addre")
    public Replpy addReply(@RequestBody Replpy replpy){
        rs.addReply(replpy);
        return replpy;
    }

    @DeleteMapping("/dere")
    public Replpy deleteReply(@RequestBody Replpy replpy){
        rs.deleteReply(replpy);
        return replpy;
    }
}
