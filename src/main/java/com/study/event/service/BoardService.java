package com.study.event.service;

import com.study.event.domain.Board;
import com.study.event.domain.History;
import com.study.event.dtos.BoardRequest;
import com.study.event.event.CreatedBoard;
import com.study.event.repository.BoardRepository;
import com.study.event.repository.HistoryRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final HistoryRepository historyRepository;
    private final ApplicationEventPublisher eventPublisher;

    public BoardService(BoardRepository boardRepository, HistoryRepository historyRepository, ApplicationEventPublisher publisher) {
        this.boardRepository = boardRepository;
        this.historyRepository = historyRepository;
        this.eventPublisher = publisher;
    }

    @Transactional
    public long createNotEvent(BoardRequest boardRequest){
        Board createBoard = boardRequest.toBoard();
        Board savedBoard = boardRepository.save(createBoard);
        historyRepository.save(new History(createBoard));
        return savedBoard.getId();
    }

    public Board findBoardById(long id) {
        return boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public long createWithEvent(BoardRequest boardRequest) {
        Board createBoard = boardRequest.toBoard();
        Board savedBoard = boardRepository.save(createBoard);
        eventPublisher.publishEvent(new CreatedBoard(savedBoard.getId()));
        return savedBoard.getId();
    }
}
