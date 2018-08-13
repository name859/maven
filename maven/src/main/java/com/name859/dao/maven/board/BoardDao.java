package com.name859.dao.maven.board;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.name859.domain.maven.board.Board;

public interface BoardDao extends JpaRepository<Board, Long> {

	Page<Board> findBySubjectLikeOrContentLikeOrUserNameLike(String subject, String content, String userName, Pageable pageable);
	
	Page<Board> findBySubjectLike(String subject, Pageable pageable);
	
	Page<Board> findByContentLike(String content, Pageable pageable);
	
	Page<Board> findByUserNameLike(String userName, Pageable pageable);
	
	Page<Board> findByVital(String vital, Pageable pageable);
	
}
