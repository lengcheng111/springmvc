package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@RequestMapping(value = "showLogin")
	public String showLogin() {
		return "login";
	}
	// TODO sinh viên tìm hiểu xử lý method post 
	@RequestMapping(value = "doLogin")
	public String login(@RequestParam("name") String name, @RequestParam("pass") String pass, Model model) {
		if (name.equals(pass)) {
			model.addAttribute("message", name);
			return "welcome";
		}
		model.addAttribute("message", "name and password must be the same!");
		return "login";
	}
}
