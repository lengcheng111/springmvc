package com.edu.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.edu.entity.UploadModel;
import com.edu.entity.User;

@Controller
public class UploadController {

	@Autowired
	SessionFactory sessionfactory;

	@RequestMapping(value = "toupload")
	public String toUpload(Model model) {
		System.out.println("da vao day");
		UploadModel uploadModel = new UploadModel();
		model.addAttribute("uploadModel", uploadModel);
		return "UploadFile";
	}

	@RequestMapping(value = "doupload", method = RequestMethod.POST)
	public String doUpload(Model model, @ModelAttribute("uploadModel") UploadModel uploadModel) {
		System.out.println("da vao day1");
		CommonsMultipartFile[] fileDatas = uploadModel.getFileDatas();
		for (CommonsMultipartFile file : fileDatas) {
			User user = new User();
			user.setPicture(file.getBytes());
			Session session = sessionfactory.openSession();
			session.beginTransaction();
			System.out.println("da vao day2");

			session.save(user);
			session.getTransaction().commit();
			session.close();
			System.out.println("da vao day3");
		}

		model.addAttribute("messenger", "OK");
		return "Success";
	}

}
