package com.name859.web.maven.user.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.domain.maven.user.User;
import com.name859.service.maven.user.UserService;
import com.name859.web.GeneralController;

@Controller
@RequestMapping("/a/user")
public class UserAdminController extends GeneralController<User, UserService, PageParam, SearchParam> {

	@RequestMapping(value = "/choice", method = RequestMethod.GET)
	public String choice(HttpServletRequest request, PageParam pageParam, SearchParam searchParam, Model model) {
		this.makeList(request.getContextPath() + baseUrl +"/choice", pageParam, searchParam, model);
		this.modelAddBaseUrl("/choice", model);
		
		return viewDir +"/choice";
	}
	
}
