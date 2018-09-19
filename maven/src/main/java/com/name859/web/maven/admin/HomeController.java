package com.name859.web.maven.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a/home")
public class HomeController {

	@RequestMapping()
	public String home() {
		return "/admin/home";
	}
	
}
