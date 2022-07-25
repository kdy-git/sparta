package com.sparta.boardassignment.controller;

import com.sparta.boardassignment.domain.Board;
import com.sparta.boardassignment.domain.BoardDto;
import com.sparta.boardassignment.domain.BoardRepository;
import com.sparta.boardassignment.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    @PostMapping("/api/boards")
    public Board create(@RequestBody BoardDto boardDto) {
        Board board = new Board(boardDto);  // 입력한값 받아와 board 생성자에 넣어주고
        return boardRepository.save(board); // 그걸 DB에 save
    }

    @GetMapping("/api/boards")
    public List<Board> getBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @PostMapping("/api/boards/{no}")
    public Board read(@PathVariable Long no) {

        return boardRepository.findById(no).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
    }

    @DeleteMapping("/api/boards/{no}")
    public Long deleteBoard(@PathVariable Long no, @RequestBody BoardDto boardDto) {
        if(boardService.PasswordCheck(no, boardDto)) {
            boardRepository.deleteById(no);
        }else {
            return 0L;
        }
        return no;
    }

    @PutMapping("/api/boards/{no}")
    public Long updateBoard(@PathVariable Long no, @RequestBody BoardDto boardDto) {
       if(boardService.PasswordCheck(no, boardDto)) {
            boardService.update(no, boardDto);
       }else {
           return -1L;
       }
        return no;
    }
}
