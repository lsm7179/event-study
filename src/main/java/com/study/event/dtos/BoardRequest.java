package com.study.event.dtos;

import com.study.event.domain.Board;
import lombok.Data;

@Data
public class BoardRequest {
    private String title;
    private String content;

    public Board toBoard() {
        return new Board(title, content);
    }
}
