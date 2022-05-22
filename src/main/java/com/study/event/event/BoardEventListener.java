package com.study.event.event;


import com.study.event.domain.Board;
import com.study.event.domain.History;
import com.study.event.repository.BoardRepository;
import com.study.event.repository.HistoryRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Transactional(propagation = Propagation.REQUIRES_NEW)
@Component
public class BoardEventListener {

    private final BoardRepository boardRepository;
    private final HistoryRepository historyRepository;

    public BoardEventListener(BoardRepository boardRepository, HistoryRepository historyRepository) {
        this.boardRepository = boardRepository;
        this.historyRepository = historyRepository;
    }

    @TransactionalEventListener
    public void createBoardEvent(CreatedBoard createdBoard) {
        Board board = boardRepository.findById(createdBoard.getBoardId())
                .orElseThrow(IllegalArgumentException::new);
        historyRepository.save(new History(board));
    }
}
