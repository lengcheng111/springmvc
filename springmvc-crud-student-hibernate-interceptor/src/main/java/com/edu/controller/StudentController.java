package com.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.dao.StudentDAO;
import com.edu.model.Student;

@Controller
public class StudentController {

	@Autowired
	private StudentDAO studentDao;

	@RequestMapping("showStudent")
	public String showStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("students", studentDao.getAll());
		return "student";
	}

	@RequestMapping("list")
	public String getStudents(Model model) {
		model.addAttribute("students", studentDao.getAll());
		return "student";
	}

	@RequestMapping(value = "studentProcess", params = { "reset=Submit" })
	public String reset(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("students", studentDao.getAll());
		return "student";
	}

	@RequestMapping(value = "studentProcess", params = { "add=Add" })
	public String save(@ModelAttribute("student") Student student, Model model) {

		this.studentDao.save(student);
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "studentProcess", params = { "update=Update" })
	public String update(@ModelAttribute("student") Student student, Model model) {
		if (student.getId() > 0) {
			this.studentDao.update(student);
		}
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {
		this.studentDao.delete(this.studentDao.getStudent(id));
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("students", studentDao.getAll());
		model.addAttribute("student", this.studentDao.getStudent(id));
		return "student";
	}
}
