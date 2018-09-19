package com.name859.web.maven.board.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.comment.Comment;
import com.name859.domain.maven.user.User;
import com.name859.service.maven.board.BoardService;
import com.name859.service.maven.user.UserService;
import com.name859.web.GeneralController;

@Controller
@RequestMapping("/a/board")
public class BoardController extends GeneralController<Board, BoardService, PageParam, SearchParam> {

	@Autowired protected UserService userService;
	
	@Override
	public String read(@PathVariable("domainId") Long domainId, PageParam pageParam, SearchParam searchParam, Model model) {
		model.addAttribute("comment", new Comment());
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		
		return super.read(domainId, pageParam, searchParam, model);
	}
	
	@Override
	public String addForm(PageParam pageParam, SearchParam searchParam, Model model) {
		Board board = new Board();
		board.setGroupId((long)0);
		board.setReferenceId((long)0);
		board.setSequence(1);
		board.setLevel(1);
		
		model.addAttribute("board", board);
		
		return super.addForm(pageParam, searchParam, model);
	}
	
	@RequestMapping(value = "/fm/{domainId}", method = RequestMethod.GET)
	public String addForm(@PathVariable("domainId") Long domainId, PageParam pageParam, SearchParam searchParam, Model model) {
		Board board = service.findById(domainId);
		board.setReferenceId(board.getBoardId());
		board.setSequence(board.getSequence() + 1);
		board.setLevel(board.getLevel() + 1);
		
		model.addAttribute("board", board);
		
		return super.addForm(pageParam, searchParam, model);
	}
	
	@Override
	public String modify(@PathVariable("domainId") Long domainId, @ModelAttribute("domain") Board domain, PageParam pageParam, SearchParam searchParam, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		User user = new User();
		user.setUserId(domain.getUser().getUserId());
		domain.setUser(user);
		
		return super.modify(domainId, domain, pageParam, searchParam, bindingResult, sessionStatus, model);
	}
	
}
