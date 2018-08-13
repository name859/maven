package com.name859.service.maven.comment;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.comment.Comment;
import com.name859.domain.maven.user.User;
import com.name859.util.Number;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class CommentServiceTest {

	@Autowired private CommentService service;
	
	private Number number = new Number();
	
	private Comment makeComment(Board board, User user) {
		int rn = number.getRandomNumber(100, 999);
		
		Comment comment = new Comment();
		comment.setComment("Comment Comment No."+ rn);
		comment.setVital("N");
		comment.setBoard(board);
		comment.setUser(user);
		
		return comment;
	}
	
	@Test
	public void commentIO() throws Exception {
		Board board = new Board();
		User user = new User();
		for (int i = 0; i < 50; i++) {
			board.setBoardId((long)number.getRandomNumber(100021, 100050));
			user.setUserId((long)number.getRandomNumber(100001, 100020));
			
			Comment comment = makeComment(board, user);
			System.out.println("@@@ Before Save Add Comment : "+ comment.toString());
			
			comment = service.add(comment);
			System.out.println("@@@ After Save Add commentId : "+ comment.getCommentId());
			
			comment = service.findById(comment.getCommentId());
			System.out.println("@@@ After Save Add Comment : "+ comment.toString());
			
			comment.setVital("Y");
			System.out.println("@@@ Before Save Modify Comment : "+ comment.toString());
			
			comment = service.modify(comment);
			System.out.println("@@@ After Save Modify commentId : "+ comment.getCommentId());
			
			comment = service.findById(comment.getCommentId());
			System.out.println("@@@ After Save Modify Comment : "+ comment.toString());
		}
		
		List<Comment> list = service.findAll();
		System.out.println("@@@ Comment List Size : "+ list.size());
		
		for (Comment comment : list) {
			System.out.println("@@@ Comment List ["+ list.indexOf(comment) +"] : "+ comment.toString());
		}
	}
	
}
