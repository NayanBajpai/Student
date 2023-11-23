package com.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;

@SpringBootApplication
//public class StudentApplication implements CommandLineRunner{
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}
	
//	@Autowired
//	private StudentRepository studentRepository;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		
//		Student student1 = new Student("Nayan", 23L, 1000L);
//		studentRepository.save(student1);
//		
//		Student student2 = new Student("Rahul", 23L, 1000L);
//		studentRepository.save(student2);
//		
//		Student student3 = new Student("Ayush", 23L, 1000L);
//		studentRepository.save(student3);
//		
//	}

}
