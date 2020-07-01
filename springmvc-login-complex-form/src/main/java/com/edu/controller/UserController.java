package com.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edu.model.User;

@Controller
public class UserController {

	@RequestMapping(value = "showManageUser")
	public String showManageUser(Model model) {
		// khởi tạo đối tượng User, hiển thị lên màn hình
		model.addAttribute("userView", new User());
		return "manage-user";
	}

	@RequestMapping(value = "doUser", params = { "save=Save" })
	public String save(@ModelAttribute("userView") User userView, Model model) {
		System.out.println(userView);
		return "manage-user";
	}

	@RequestMapping(value = "doUser", params = { "update=Update" })
	public String update(@ModelAttribute("userView") User userView, Model model) {
		System.out.println(userView);
		return "manage-user";
	}

}
