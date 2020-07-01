package com.edu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailController {

	@Autowired
	private JavaMailSender sender;

	@RequestMapping(value = "showFormMail")
	public String showFormMail(HttpServletRequest request, Model model) {
		SimpleMailMessage simpleMessage = new SimpleMailMessage();
		simpleMessage.setTo("truonglv174@gmail.com");
		simpleMessage.setSubject("Subject: day la subject");
		simpleMessage.setText("noi dung blabla ...");
		sender.send(simpleMessage);
		return "mail";
	}

	@RequestMapping(value = "sendMail")
	public String sendMail(HttpServletRequest request, HttpServletResponse response, Model model) {

		return "mail";
	}

}
