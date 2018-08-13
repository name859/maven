package com.name859.dao.maven.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.name859.domain.maven.board.BoardNice;

public interface BoardNiceDao extends JpaRepository<BoardNice, Long> {

	Page<BoardNice> findByBoardBoardId(Long boardBoardId, Pageable pageable);
	
	Page<BoardNice> findByBoardBoardIdAndVital(Long boardBoardId, String vital, Pageable pageable);
	
	BoardNice findByBoardBoardIdAndUserUserId(Long boardBoardId, Long userUserId);
	
}
