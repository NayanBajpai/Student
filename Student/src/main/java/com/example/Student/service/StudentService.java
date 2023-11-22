package com.example.Student.service;

import java.util.List;
import java.util.Optional;

import com.example.Student.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Optional<Student> findById(Long id);
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	void deleteStudent(Long id);

}
