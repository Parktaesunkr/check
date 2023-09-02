package com.spr.neterpark.entity;

import lombok.Data;

@Data
public class DeleteMember {

    private User user;

    private Board board;

    private Replpy replpy;

    private Basket basket;

    private Salaylist salaylist;

    private Notice notice;
}
