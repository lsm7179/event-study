package com.study.event.service;

import com.study.event.domain.Board;
import com.study.event.domain.History;
import com.study.event.dtos.BoardRequest;
import com.study.event.repository.BoardRepository;
import com.study.event.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final HistoryRepository historyRepository;

    public BoardService(BoardRepository boardRepository, HistoryRepository historyRepository) {
        this.boardRepository = boardRepository;
        this.historyRepository = historyRepository;
    }

    public long createNotEvent(BoardRequest boardRequest){
        Board createBoard = boardRequest.toBoard();
        Board savedBoard = boardRepository.save(createBoard);
        historyRepository.save(new History(createBoard));
        return savedBoard.getId();
    }
}
