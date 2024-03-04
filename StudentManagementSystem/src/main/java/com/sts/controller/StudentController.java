package com.sts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sts.entity.Student;
import com.sts.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
//	Homepage
	@GetMapping("/")
	public String homepage() {
		return "homepage";
	}
//	Add employe
	@GetMapping("/addstudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student",student);
		return "addstupage";
	}
	@PostMapping("/saveStudent")
	public String saveEmploye(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/showstudent";
	}
	
//	Show list of employe
	@GetMapping("/showstudent")
	public String showAllEmploye(Model model){
		model.addAttribute("studentlist",studentService.showList());
		return "stulist";
	}
//	delete employe by id
	@GetMapping("/deletestudent/{id}")
	public String deletestudentbyId(@PathVariable long id) {
		studentService.deletestudent(id);
		return "redirect:/showstudent";
	}
//	updatestudent by id
	@GetMapping("/updatestudent/{id}")
	public String updateStudent(@PathVariable long id,Model model) {
		Student student = studentService.updateStudentbyId(id);
		model.addAttribute("student",student);
		studentService.saveStudent(student);
		return "updatestudent";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
