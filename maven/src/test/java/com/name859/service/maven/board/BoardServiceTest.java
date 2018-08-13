package com.name859.service.maven.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.user.User;
import com.name859.util.Number;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
public class BoardServiceTest {

	@Autowired private BoardService service;
	
	private Number number = new Number();
	
	private Board makeBoard(User user) {
		int rn = number.getRandomNumber(100, 999);
		
		Board board = new Board();
		board.setSubject("Board Subject No."+ rn);
		board.setContent("Board Content No."+ rn);
		board.setVital("N");
		board.setUser(user);
		
		return board;
	}
	
	@Test
	public void boardIO() throws Exception {
		User user = new User();
		for (int i = 0; i < 30; i++) {
			user.setUserId((long)number.getRandomNumber(100001, 100020));
			
			Board board = makeBoard(user);
			System.out.println("@@@ Before Save Add Board : "+ board.toString());
			
			board = service.add(board);
			System.out.println("@@@ After Save Add boardId : "+ board.getBoardId());
			
			board = service.findById(board.getBoardId());
			System.out.println("@@@ After Save Add Board : "+ board.toString());
			
			board.setVital("Y");
			System.out.println("@@@ Before Save Modify Board : "+ board.toString());
			
			board = service.modify(board);
			System.out.println("@@@ After Save Modify boardId : "+ board.getBoardId());
			
			board = service.findById(board.getBoardId());
			System.out.println("@@@ After Save Modify Board : "+ board.toString());
		}
		
		List<Board> list = service.findAll();
		System.out.println("@@@ Board List Size : "+ list.size());
		
		for (Board board : list) {
			System.out.println("@@@ Board List ["+ list.indexOf(board) +"] : "+ board.toString());
		}
	}
	
}
