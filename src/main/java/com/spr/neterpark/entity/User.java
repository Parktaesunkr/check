package com.spr.neterpark.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
public class User {

    @Id
    @Column(length = 10)
    private String userId; // 아이디

    @Column(length = 5, nullable = false)
    private String userName; // 이름

    @Column(length = 50, nullable = false)
    private String userPwd; // 비밀번호

    @Column(length = 20, nullable = false)
    private String userEmail; // 이메일

    @Column(length = 3)
    private String userPhoneF; // 휴대전화 앞자리 3자리

    @Column(length = 4)
    private String userPhoneM; // 휴대전화 중간 4자리

    @Column(length = 4)
    private String userPhoneL; // 휴대전화 끝자리 4자리

    @Column(length = 20)
    private String userAddr; // 주소

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // user 삭제시 board삭제
    private List<Board> board;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // user 삭제시 reply삭제
    private List<Replpy> replpy;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // user 삭제시 basket삭제
    private List<Basket> basket;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // user 삭제시 salaylist삭제
    private List<Salaylist> salaylist;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // user 삭제시 notice삭제
    private List<Notice> notice;

}
