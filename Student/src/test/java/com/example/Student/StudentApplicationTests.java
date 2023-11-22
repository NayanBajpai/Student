package com.example.Student;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;
import com.example.Student.service.StudentService;

@SpringBootTest
class StudentApplicationTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20L, 50000L));
        students.add(new Student("Alice", 22L, 60000L));

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals(22, result.get(1).getAge());
    }

    @Test
    void testGetStudentById() {
        long studentId = 1L;
        Student john = new Student("John", 20L, 50000L);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(john));

        Optional<Student> result = studentService.findById(studentId);

        assertEquals(true, result.isPresent());
        assertEquals("John", result.get().getName());
        assertEquals(50000, result.get().getSalary());
    }
    
    
    @Test
    void testCreateStudent() {
        Student newStudent = new Student("Jane", 21L, 55000L);
        when(studentRepository.save(any(Student.class))).thenReturn(new Student("Jane", 21L, 55000L));

        Student createdStudent = studentService.saveStudent(newStudent);

        assertEquals("Jane", createdStudent.getName());
        assertEquals(21, createdStudent.getAge());
        assertEquals(55000, createdStudent.getSalary());
    }
    
    @Test
    void testUpdateStudent() {
        long studentId = 1L;
        Student existingStudent = new Student("John", 20L, 50000L);
        Student updatedStudentInfo = new Student("John Doe", 22L, 60000L);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(existingStudent));
        when(studentRepository.save(any(Student.class))).thenReturn(new Student("John Doe", 22L, 60000L));

        Student updatedStudent = studentService.updateStudent(updatedStudentInfo);

        //assertTrue(updatedStudent.isPresent());
        assertEquals("John Doe", updatedStudent.getName());
        assertEquals(22, updatedStudent.getAge());
        assertEquals(60000, updatedStudent.getSalary());
    }
    
}