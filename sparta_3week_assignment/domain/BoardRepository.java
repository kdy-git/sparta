package com.sparta.boardassignment.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> { // Board Entity의 id가 Long인것에 대해 jparepository 생성

    List<Board> findAllByOrderByCreatedAtDesc(); // 찾아낸것들을 생성시간 기준 내림차순 정렬
}
