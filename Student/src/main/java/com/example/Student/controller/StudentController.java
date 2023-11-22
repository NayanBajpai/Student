package com.example.Student.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/{id}")
    public Optional<Student> findUserById(@PathVariable("id") Long id) {
    	return studentService.findById(id);
    }
    
    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
    	 return studentService.saveStudent(student);
    }
    
    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
    	return studentService.updateStudent(student);
    }
    
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
    	studentService.deleteStudent(id);
    }

}
