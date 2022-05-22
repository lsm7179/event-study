package com.study.event.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryTest {

    @DisplayName("생성검증")
    @Test
    void create() {
        Board board = new Board("title", "content");

        History history = new History(board);

        assertThat(history).isNotNull();
    }
}
