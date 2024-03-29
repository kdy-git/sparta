package com.sparta.week4.service;

import com.sparta.week4.dto.BoardDto;
import com.sparta.week4.entity.Board;
import com.sparta.week4.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor // final 선언된 변수에 대해 서버시작과 동시에 생성자를 만들어주는 역할
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void update(Long no, BoardDto boardDto) { // update 메서드

        Board board = boardRepository.findById(no).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        board.update(boardDto);
    }

    public boolean PasswordCheck(Long no, @RequestBody BoardDto boardDto) {  // 비밀번호 Check

        Board board = boardRepository.findById(no).get();

        return boardDto.getPassword().equals(board.getPassword());
    }

}
