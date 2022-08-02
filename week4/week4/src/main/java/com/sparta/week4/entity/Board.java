package com.sparta.week4.entity;

import com.sparta.week4.dto.BoardDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity  // table 임을 선언하는것과 같다.
public class Board extends Timestamped {

    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)  // Auto_increment
    private Long no;

    @Column(nullable = false)  // not null
    private String title;

    @Column(nullable = false)  // not null
    private String contents;

    @Column(nullable = false)  // not null
    private String writer;

    @Column(nullable = false)  // not null
    private String password;

    public Board(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
        this.writer = boardDto.getWriter();
        this.password = boardDto.getPassword();
    }

    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.contents = boardDto.getContents();
    }
}