package com.study.event.event;

import lombok.Data;

@Data
public class CreatedBoard {
    private long boardId;

    public CreatedBoard(long boardId) {
        this.boardId = boardId;
    }
}
