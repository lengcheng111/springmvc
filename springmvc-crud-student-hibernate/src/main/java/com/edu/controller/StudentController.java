package com.edu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	private final static String TYPE_ASC = "asc";
	private final static String TYPE_DESC = "desc";
	private final static int PAGE_SIZE = 5;

	@RequestMapping("showStudent")
	public String showStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("sortingStyle", TYPE_ASC);
		model.addAttribute("students", studentDao.getAll(1, PAGE_SIZE));
		final int totalPage = studentDao.countStudent() / PAGE_SIZE;
		model.addAttribute("totalPage", totalPage);
		return "student";
	}

	@RequestMapping("/showStudent/{pageId}")
	public String showStudentWithPageId(@PathVariable("pageId") int pageId, Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("sortingStyle", TYPE_ASC);
		model.addAttribute("students", studentDao.getAll(pageId * PAGE_SIZE, PAGE_SIZE));
		final int totalPage = studentDao.countStudent() / PAGE_SIZE;
		model.addAttribute("totalPage", totalPage);
		return "student";
	}

	@RequestMapping("list")
	public String getStudents(Model model) {
		model.addAttribute("students", studentDao.getAll(null, PAGE_SIZE));
		return "student";
	}

	@RequestMapping(value = "studentProcess", params = { "reset=Submit" })
	public String reset(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("students", studentDao.getAll(null, PAGE_SIZE));
		return "student";
	}

	@RequestMapping(value = "studentSearch")
	public String search(@RequestParam("search") String search, Model model) {
		if (search == null || search.equals("")) {
			model.addAttribute("students", studentDao.getAll(null, PAGE_SIZE));
		} else {
			model.addAttribute("students", studentDao.search(search));
		}
		final int totalPage = studentDao.countStudent() / PAGE_SIZE;
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("student", new Student());
		return "student";
	}

	@RequestMapping(value = "/order")
	public String order(@RequestParam("order") String order, @RequestParam("columnName") String columnName,
			Model model) {
		boolean asc = true; // by default
		int offSet = 1;
		int maxResult = PAGE_SIZE;
		final int totalRows = studentDao.countStudent();
		if (TYPE_ASC.equals(order)) {
			model.addAttribute("sortingStyle", TYPE_DESC);
		} else {
			offSet = totalRows - PAGE_SIZE;
			maxResult = totalRows;
			model.addAttribute("sortingStyle", TYPE_ASC);
			asc = false;
		}
		model.addAttribute("students", studentDao.orderByColumnName(asc, columnName, offSet, maxResult));
		model.addAttribute("student", new Student());

		final int totalPage = totalRows / PAGE_SIZE;
		model.addAttribute("totalPage", totalPage);

		return "student";
	}

	@RequestMapping(value = "studentProcess", params = { "add=Add" })
	public String save(@ModelAttribute("student") Student student, Model model) throws Exception {
		this.studentDao.save(student);
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "studentProcess", params = { "update=Update" })
	public String update(@ModelAttribute("student") Student student, Model model) throws Exception {
		this.studentDao.update(student);
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) throws Exception {
		this.studentDao.delete(this.studentDao.getStudent(id));
		return "redirect:/showStudent";
	}

	@RequestMapping(value = "edit")
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("students", studentDao.getAll(null, PAGE_SIZE));
		model.addAttribute("student", this.studentDao.getStudent(id));
		final int totalPage = studentDao.countStudent() / PAGE_SIZE;
		model.addAttribute("totalPage", totalPage);
		return "student";
	}

	@ExceptionHandler(Exception.class)
	public final String handleAllExceptions(Exception ex, Model model) {
		final List<String> details = new ArrayList<String>();
		details.add(ex.getLocalizedMessage());
		model.addAttribute("errors", details);
		return "error";
	}

}
