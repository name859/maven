package com.name859.web.maven.category.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.name859.common.page.PageParam;
import com.name859.common.search.SearchParam;
import com.name859.domain.maven.category.Category;
import com.name859.domain.maven.user.User;
import com.name859.service.maven.category.CategoryService;
import com.name859.web.GeneralController;

@Controller
@RequestMapping("/a/category")
public class CategoryAdminController extends GeneralController<Category, CategoryService, PageParam, SearchParam> {

	@Override
	public String list(HttpServletRequest request, PageParam pageParam, SearchParam searchParam, Model model) {
		return "redirect:/a/user";
	}
	
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public String list(@PathVariable("userId") Long userId, HttpServletRequest request, PageParam pageParam, SearchParam searchParam, Model model) {
		List<Category> list = service.findByUserId(userId);
		model.addAttribute("list", list);
		model.addAttribute("totalRecord", list.size());
		modelAddBaseUrl(model);
		
		model.addAttribute("userId", userId);
		
		return this.viewDir +"/list";
	}
	
	@Override
	public String addForm(Model model) {
		return "redirect:/a/user";
	}
	
	@RequestMapping(value = "/fm/user/{userId}", method = RequestMethod.GET)
	public String addFormLevel1(@PathVariable("userId") Long userId, Model model) {
		Category category = new Category();
		category.setGroupId((long)0);
		category.setReferenceId((long)0);
		category.setSequence(1);
		category.setLevel(1);
		
		User user = new User();
		user.setUserId(userId);
		category.setUser(user);
		
		model.addAttribute("category", category);
		
		return super.addForm(model);
	}
	
	@RequestMapping(value = "/fm/{domainId}", method = RequestMethod.GET)
	public String addFormLevel2(@PathVariable("domainId") Long domainId, Model model) {
		Category category = service.findById(domainId);
		category.setReferenceId(category.getCategoryId());
		category.setSequence(category.getSequence() + 1);
		category.setLevel(category.getLevel() + 1);
		
		model.addAttribute("category", category);
		
		return super.addForm(model);
	}
	
	@Override
	public String add(Category domain, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) return this.viewDir +"/add";
		service.add(domain);
		sessionStatus.setComplete();
		
		return "redirect:"+ baseUrl +"/user/"+ domain.getUser().getUserId();
	}
	
	@Override
	public String delete(@PathVariable("domainId") Long domainId, PageParam pageParam, SearchParam searchParam, Model model) {
		Long userId = service.findById(domainId).getUser().getUserId();
		
		service.deleteById(domainId);
		
		return "redirect:"+ baseUrl +"/user/"+ userId;
	}
	
}
