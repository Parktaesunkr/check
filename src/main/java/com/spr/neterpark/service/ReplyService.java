package com.spr.neterpark.service;

import com.spr.neterpark.entity.Replpy;
import com.spr.neterpark.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;


    public List<Replpy> listReply(Replpy replpy){
        return replyRepository.findBybno(replpy.getBno());
    }

    public int updateReply(Replpy replpy){
        replyRepository.save(replpy);
        return 1;
    }

    public int addReply(Replpy replpy){
        replyRepository.save(replpy);
        return 1;
    }

    public int deleteReply(Replpy replpy){
        replyRepository.deleteById(replpy.getRno());
        return 1;
    }

}
