package com.study.event.service;

import com.study.event.domain.Board;
import com.study.event.dtos.BoardRequest;
import com.study.event.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public long createNotEvent(BoardRequest boardRequest){
        Board createBoard = boardRequest.toBoard();
        Board savedBoard = boardRepository.save(createBoard);
        return savedBoard.getId();
    }
}
