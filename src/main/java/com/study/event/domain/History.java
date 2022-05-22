package com.study.event.domain;


import javax.persistence.*;

@Entity
public class History extends BaseTimeEntity{

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board createBoard;

    protected History() {
    }

    public History(Board createBoard) {
        this.createBoard = createBoard;
    }
}
