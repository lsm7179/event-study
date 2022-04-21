package com.study.event.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BoardTest {

    @DisplayName("게시판 생성 검증")
    @Test
    void create() {
        //제목, 내용
        Board board = new Board("제목", "내용입니다.");

        assertThat(board).isNotNull();
    }
}
