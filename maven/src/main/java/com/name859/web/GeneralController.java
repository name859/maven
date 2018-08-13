package com.name859.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.name859.common.page.PageNavi;
import com.name859.common.page.PageParam;
import com.name859.common.param.Param;
import com.name859.common.search.SearchParam;
import com.name859.service.GeneralService;
import com.name859.util.Generic;

@SessionAttributes("domain")
public class GeneralController<D, DS extends GeneralService<D, PP, SP>, PP extends PageParam, SP extends SearchParam> {

	@Autowired protected DS service;
	
	protected Class<D> domainClass;
	
	protected Param param = new Param();
	
	protected String baseUrl = "";
	protected String viewDir = "";
	
	@SuppressWarnings("unchecked")
	public GeneralController() {
		baseUrl = getClass().getAnnotation(RequestMapping.class).value()[0];
		viewDir = "/admin"+ baseUrl.substring(2);
		
		domainClass = Generic.getClassOfGenericType(getClass(), 0);
	}
	
	protected void modelAddBaseUrl(Model model) {
		model.addAttribute("baseUrl", baseUrl);
	}
	
	protected void modelAddBaseUrl(String exUrl, Model model) {
		model.addAttribute("baseUrl", baseUrl + exUrl);
	}
	
	private void makeListAction(Page<D> page, String baseUrl, PP pageParam, SP searchParam, Model model) {
		List<D> list = page.getContent();
		
		PageNavi pageNavi = new PageNavi();
		pageNavi.init(page, baseUrl, param.makeParam(pageParam.getParam(), searchParam.getParam()), pageParam.getCurrentPage(), pageParam.getViewRecord(), pageParam.getViewPage());
		
		model.addAttribute("list", list);
		model.addAttribute("pagination", pageNavi.getPagination());
		model.addAttribute("totalRecord", pageNavi.getTotalRecord());
	}
	
	protected void makeList(String baseUrl, PP pageParam, SP searchParam, Model model) {
		Page<D> page = service.findAll(pageParam, searchParam);
		
		makeListAction(page, baseUrl, pageParam, searchParam, model);
	}
	
	protected void makeList(Page<D> page, String baseUrl, PP pageParam, SP searchParam, Model model) {
		makeListAction(page, baseUrl, pageParam, searchParam, model);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(HttpServletRequest request, PP pageParam, SP searchParam, Model model) {
		makeList(request.getContextPath() + baseUrl, pageParam, searchParam, model);
		modelAddBaseUrl(model);
		
		model.addAttribute("parameter", param.makeParam(pageParam.getParam(), searchParam.getParam()));
		
		return viewDir +"/list";
	}
	
	@RequestMapping(value = "/{domainId}", method = RequestMethod.GET)
	public String read(@PathVariable("domainId") Long domainId, PP pageParam, SP searchParam, Model model) {
		D domain = service.findById(domainId);
		model.addAttribute("domain", domain);
		model.addAttribute("parameter", param.makeParam(pageParam.getParam(), searchParam.getParam()));
		modelAddBaseUrl(model);
		
		return viewDir +"/read";
	}
	
	@RequestMapping(value = "/fm", method = RequestMethod.GET)
	public String addForm(Model model) {
		try {
			model.addAttribute("domain", domainClass.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		modelAddBaseUrl(model);
		
		return viewDir +"/add";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String add(D domain, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) return viewDir +"/add";
		service.add(domain);
		sessionStatus.setComplete();
		
		return "redirect:"+ baseUrl;
	}
	
	@RequestMapping(value = "/{domainId}/fm", method = RequestMethod.GET)
	public String modifyForm(@PathVariable("domainId") Long domainId, PP pageParam, SP searchParam, Model model) {
		D domain = service.findById(domainId);
		model.addAttribute("domain", domain);
		modelAddBaseUrl(model);
		
		return viewDir +"/modify";
	}
	
	@RequestMapping(value = "/{domainId}", method = RequestMethod.POST)
	public String modify(@PathVariable("domainId") Long domainId, @ModelAttribute("domain") D domain, PP pageParam, SP searchParam, BindingResult bindingResult, SessionStatus sessionStatus, Model model) {
		if (bindingResult.hasErrors()) return viewDir +"/modify";
		service.modify(domain);
		sessionStatus.setComplete();
		
		return "redirect:"+ baseUrl +"/"+ domainId +"?"+ param.makeParam(pageParam.getParam(), searchParam.getParam());
	}
	
	@RequestMapping(value = "/{domainId}/del", method = RequestMethod.GET)
	public String delete(@PathVariable("domainId") Long domainId, PP pageParam, SP searchParam, Model model) {
		service.deleteById(domainId);
		
		return "redirect:"+ baseUrl +"?"+ param.makeParam(pageParam.getParam(), searchParam.getParam());
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	
	public String getViewDir() {
		return viewDir;
	}
	
	public void setViewDir(String viewDir) {
		this.viewDir = viewDir;
	}
	
}
