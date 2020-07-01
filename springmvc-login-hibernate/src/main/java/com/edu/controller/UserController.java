package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.dao.UserDAO;
import com.edu.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;

	@RequestMapping(value = "login")
	public String showLogin(ModelMap model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "register")
	public String showRegister(ModelMap model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@RequestMapping(value = "registerProcess", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user, ModelMap model) {
		if (userDao.getUser(user.getUserName()) == null) {
			userDao.save(new User(user.getUserName(), user.getPwd()));
			model.addAttribute("message", user.getUserName());
			return "welcome";
		} else {
			model.addAttribute("message", "the user already existed!");
			return "register";
		}
	}

	@RequestMapping(value = "loginProcess", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, ModelMap model) {
		if (!userDao.getUser(user.getUserName(), user.getPwd()).isEmpty()) {
			model.addAttribute("message", user.getUserName());
			return "welcome";
		}
		model.addAttribute("message", "invalid username or password !");
		return "login";
	}
}
