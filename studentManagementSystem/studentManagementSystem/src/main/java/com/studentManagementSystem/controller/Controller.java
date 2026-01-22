package com.studentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.studentManagementSystem.entity.Student;
import com.studentManagementSystem.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {	
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/home")
	public String home()
	{
		return "home"; // view page html file -> home.html
	}

	@GetMapping("/students")
	public String getAllStudent(Model model)
	{
		model.addAttribute("students" ,service.getAllStudents());
		return "students";
	}
	

    // Show form to add new student
    @GetMapping("/students/new")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    // Save student
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        service.saveStudent(student);
        return "redirect:/students";
    }

    // Show form to edit student
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable int id, Model model) {
        model.addAttribute("student", service.getStudentById(id));
        return "edit_student";
    }

    // Update student
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student) {
        Student existingStudent = service.getStudentById(id);
        existingStudent.setFirstname(student.getFirstname());
        existingStudent.setLastname(student.getLastname());
        existingStudent.setEmail(student.getEmail());
        service.updateStudent(existingStudent);
        return "redirect:/students";
    }

    // Delete student
    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        service.deleteStudentById(id);
        return "redirect:/students";
    }
	
	
	
	
}
