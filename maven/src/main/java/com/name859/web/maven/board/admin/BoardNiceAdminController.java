package com.name859.web.maven.board.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.domain.maven.board.BoardNice;
import com.name859.service.maven.board.BoardNiceService;
import com.name859.web.GeneralController;

@Controller
@RequestMapping("/a/board/nice")
public class BoardNiceAdminController extends GeneralController<BoardNice, BoardNiceService, PageParam, SearchParam> {

	public BoardNiceAdminController() {
		viewDir = "/admin"+ baseUrl.substring(2, 8);
	}
	
	@Override
	public String list(HttpServletRequest request, PageParam pageParam, SearchParam searchParam, Model model) {
		if (searchParam.getSearchOption() > 0) {
			this.makeList(request.getContextPath() + baseUrl, pageParam, searchParam, model);
			this.modelAddBaseUrl(model);
		}
		
		return viewDir +"/nice_list";
	}
	
	@Override
	public String add(BoardNice domain, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("result", "fail");
		} else {
			model.addAttribute("result", "success");
		}
		
		service.nice(domain);
		sessionStatus.setComplete();
		
		return viewDir +"/nice";
	}
	
}
