package com.name859.service.maven.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.board.BoardNice;
import com.name859.domain.maven.user.User;
import com.name859.util.Number;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class BoardNiceServiceTest {

	@Autowired private BoardNiceService service;
	
	private Number number = new Number();
	
	private BoardNice makeBoardNice(Board board, User user) {
		BoardNice boardNice = new BoardNice();
		boardNice.setVital("N");
		boardNice.setBoard(board);
		boardNice.setUser(user);
		
		return boardNice;
	}
	
	@Test
	public void boardNiceIO() throws Exception {
		Board board = new Board();
		User user = new User();
		for (int i = 0; i < 20; i++) {
			board.setBoardId((long)number.getRandomNumber(100021, 100050));
			user.setUserId((long)number.getRandomNumber(100001, 100020));
			
			BoardNice boardNice = makeBoardNice(board, user);
			System.out.println("@@@ Before Save Add BoardNice : "+ boardNice.toString());
			
			boardNice = service.add(boardNice);
			System.out.println("@@@ After Save Add boardNiceId : "+ boardNice.getBoardNiceId());
			
			boardNice = service.findById(boardNice.getBoardNiceId());
			System.out.println("@@@ After Save Add BoardNice : "+ boardNice.toString());
			
			boardNice.setVital("Y");
			System.out.println("@@@ Before Save Modify BoardNice : "+ boardNice.toString());
			
			boardNice = service.modify(boardNice);
			System.out.println("@@@ After Save Modify boardNiceId : "+ boardNice.getBoardNiceId());
			
			boardNice = service.findById(boardNice.getBoardNiceId());
			System.out.println("@@@ After Save Modify BoardNice : "+ boardNice.toString());
		}
		
		List<BoardNice> list = service.findAll();
		System.out.println("@@@ BoardNice List Size : "+ list.size());
		
		for (BoardNice boardNice : list) {
			System.out.println("@@@ BoardNice List ["+ list.indexOf(boardNice) +"] : "+ boardNice.toString());
		}
	}
	
}
