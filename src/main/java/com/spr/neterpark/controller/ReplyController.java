package com.spr.neterpark.controller;

import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReplyController {

    @Autowired
    private ReplyService rs;


    @GetMapping("/lire")
    public List<Replpy> showReply(Replpy replpy){
        return rs.listReply(replpy);
    }

    @PostMapping("/detre")
    public List<Replpy> detailReply(@RequestBody Replpy replpy){
            return rs.detailReply(replpy);
    }

    @PutMapping("/upre")
    public int updateReply(@RequestBody Replpy replpy){
        if (replpy.getUserId() != null) { // 댓글의 작성자 아이디가 null이 아닌 경우
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
        rs.addReply(replpy); // 댓글 추가
        return replpy;
    }

    @DeleteMapping("/dere")
    public void deleteReply(@RequestBody Replpy replpy){
        rs.deleteReply(replpy); // 댓글 삭제
    }
}
