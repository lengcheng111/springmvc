package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.dao.StudentDAO;
import com.edu.dao.SubjectDAO;
import com.edu.model.Subject;

@Controller
@RequestMapping("subjectManagement")
public class SubjectController {
	@Autowired
	private SubjectDAO subjectDAO;
	@Autowired
	private StudentDAO studentDao;

	@RequestMapping("showSubject")
	public String showSubject(Model model) throws Exception {
		model.addAttribute("subject", new Subject());
		model.addAttribute("subjects", subjectDAO.getAll());
		model.addAttribute("students", studentDao.getAll());
		return "subject";
	}

	@RequestMapping(value = "subjectProcess", params = { "reset=Submit" })
	public String reset(Model model) {
		model.addAttribute("subject", new Subject());
		model.addAttribute("subjects", subjectDAO.getAll());
		return "subject";
	}

	@RequestMapping(value = "subjectProcess", params = { "add=Add" })
	public String save(@ModelAttribute("subject") Subject subject, Model model) {
		subject.setStudent(studentDao.getStudent(subject.getStudentPK()));
		this.subjectDAO.save(subject);
		return "redirect:/subjectManagement/showSubject";
	}

	@RequestMapping(value = "subjectProcess", params = { "update=Update" })
	public String update(@ModelAttribute("subject") Subject subject, Model model) {
		this.subjectDAO.update(subject);
		return "redirect:/subjectManagement/showSubject";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		this.subjectDAO.delete(this.subjectDAO.getSubject(id));
		return "redirect:/subjectManagement/showSubject";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("subjects", subjectDAO.getAll());
		model.addAttribute("subject", this.subjectDAO.getSubject(id));
		model.addAttribute("students", studentDao.getAll());
		return "subject";
	}
}
