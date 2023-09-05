package com.spr.neterpark.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rmno; // 상영관 번호

    @Column(length = 50)
    private String rmName; // 상영관 이름

    @Column(length = 5)
    private int rmSeat; // 좌석 수
}
