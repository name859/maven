package com.name859.dao.maven.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.name859.domain.maven.comment.Comment;

public interface CommentDao extends JpaRepository<Comment, Long> {

	Page<Comment> findByCommentLikeOrBoardSubjectLikeOrUserNameLike(String comment, String boardSubject, String userName, Pageable pageable);
	
	Page<Comment> findByCommentLike(String comment, Pageable pageable);
	
	Page<Comment> findByBoardSubjectLike(String boardSubject, Pageable pageable);
	
	Page<Comment> findByUserNameLike(String userName, Pageable pageable);
	
}
