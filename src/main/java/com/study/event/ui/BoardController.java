package com.study.event.ui;

import com.study.event.domain.Board;
import com.study.event.dtos.BoardRequest;
import com.study.event.service.BoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardServiceBefore) {
        this.boardService = boardServiceBefore;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> findBoardById(@PathVariable long id){
        return ResponseEntity.ok(boardService.findBoardById(id));
    }

    @PostMapping("/board/v1")
    public ResponseEntity<Void> createBoardNotEvent(@RequestBody BoardRequest boardRequest) {
        long boardId = boardService.createNotEvent(boardRequest);
        URI uri = URI.create("/board"+boardId);
        return ResponseEntity.created(uri).body(null);
    }


}
