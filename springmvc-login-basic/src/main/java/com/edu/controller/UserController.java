package com.edu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.edu.model.User;

@Controller
public class UserController {

	@RequestMapping(value = "showLogin")
	public String showLogin(HttpServletRequest request, Model model) {
		final Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (final Cookie cookie : cookies) {
				if ("user-name".equals(cookie.getName())) {
					model.addAttribute("message", cookie.getValue());
					return "welcome";
				}
			}
		}
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		final Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (final Cookie cookie : cookies) {
				if ("user-name".equals(cookie.getName())) {
					model.addAttribute("message", cookie.getValue());
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					return "redirect:showLogin";
				}
			}
		}
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, HttpServletResponse response) {
		if (user.getUserName().equals(user.getPassWord())) {
			final Cookie cookie = new Cookie("user-name", user.getUserName());
			cookie.setMaxAge(3600);
			response.addCookie(cookie);

			model.addAttribute("message", user.getUserName());
			return "welcome";
		}
		model.addAttribute("message", "invalid!");
		return "login";
	}
}
