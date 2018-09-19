package com.name859.web.maven.comment.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.domain.maven.board.Board;
import com.name859.domain.maven.comment.Comment;
import com.name859.domain.maven.user.User;
import com.name859.service.maven.board.BoardService;
import com.name859.service.maven.comment.CommentService;
import com.name859.service.maven.user.UserService;
import com.name859.web.GeneralController;

@Controller
@RequestMapping("/a/comment")
public class CommentController extends GeneralController<Comment, CommentService, PageParam, SearchParam> {

	@Autowired protected BoardService boardService;
	@Autowired protected UserService userService;
	
	public CommentController() {
		viewDir = "/admin/board"+ baseUrl.substring(2);
	}
	
	protected void modelAddDomainList(Model model) {
		List<Board> boardList = boardService.findAll();
		model.addAttribute("boardList", boardList);
		
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
	}
	
	@Override
	public String addForm(PageParam pageParam, SearchParam searchParam, Model model) {
		modelAddDomainList(model);
		
		return super.addForm(pageParam, searchParam, model);
	}
	
	@Override
	public String modifyForm(@PathVariable("domainId") Long domainId, PageParam pageParam, SearchParam searchParam, Model model) {
		modelAddDomainList(model);
		
		return super.modifyForm(domainId, pageParam, searchParam, model);
	}
	
	@Override
	public String modify(@PathVariable("domainId") Long domainId, @ModelAttribute("domain") Comment domain, PageParam pageParam, SearchParam searchParam, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		Board board = new Board();
		board.setBoardId(domain.getBoard().getBoardId());
		domain.setBoard(board);
		
		User user = new User();
		user.setUserId(domain.getUser().getUserId());
		domain.setUser(user);
		
		return super.modify(domainId, domain, pageParam, searchParam, bindingResult, sessionStatus, model);
	}
	
}
