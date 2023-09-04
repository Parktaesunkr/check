package com.spr.neterpark.service;

import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;


    public List<Replpy> listReply(Replpy replpy){
        return replyRepository.findBybno(replpy.getBno());
    }

 /*   public List<Replpy> detailReply(Replpy replpy){
        return replyRepository.findByUserId(replpy.getUserId());
    }

    public List<Replpy> findByUserId(String userId){
        return replyRepository.findByUserId(userId);
    }*/

    public List<Replpy> detailReply(Replpy replpy){
        return replyRepository.findBybno(replpy.getBno());
    }

    public int updateReply(Replpy replpy){
        replyRepository.save(replpy);
        return 1;
    }

    public void addReply(Replpy replpy){
        replyRepository.save(replpy);
    }

    public void deleteReply(Replpy replpy){
        replyRepository.deleteById(replpy.getRno());
    }



}
