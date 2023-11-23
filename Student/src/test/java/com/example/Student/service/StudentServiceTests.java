package com.example.Student.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;
import com.example.Student.service.impl.StudentServiceImpl;

@SpringBootTest
class StudentServiceTests {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService = new StudentServiceImpl(studentRepository);

    @Test
    void testGetAllStudents() {
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20L, 50000L));
        students.add(new Student("Jane", 22L, 60000L));

        when(studentRepository.findAll()).thenReturn(students);

        List<Student> result = studentService.getAllStudents();

        assertEquals(2, result.size());
        assertEquals("John", result.get(0).getName());
        assertEquals("Jane", result.get(1).getName());
    }

    @Test
    void testFindById() {
        
        Long id = 1L;
        Student student = new Student("John", 20L, 50000L);

        when(studentRepository.findById(id)).thenReturn(Optional.of(student));

        Optional<Student> result = studentService.findById(id);

        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
    }

    @Test
    void testSaveStudent() {
        
        Student studentToSave = new Student("John", 20L, 50000L);
        Student savedStudent = new Student("John", 20L, 50000L);

        when(studentRepository.save(studentToSave)).thenReturn(savedStudent);

        Student result = studentService.saveStudent(studentToSave);

        assertEquals("John", result.getName());
        assertEquals(20L, result.getAge());
        assertEquals(50000L, result.getSalary());
    }

    @Test
    void testUpdateStudent() {
        
        Student studentToUpdate = new Student("John", 20L, 50000L);
        Student updatedStudent = new Student("John", 22L, 60000L);

        when(studentRepository.save(studentToUpdate)).thenReturn(updatedStudent);

        Student result = studentService.updateStudent(studentToUpdate);

        assertEquals("John", result.getName());
        assertEquals(22L, result.getAge());
        assertEquals(60000L, result.getSalary());
    }

    @Test
    void testDeleteStudent() {
        
        Long id = 1L;
        studentService.deleteStudent(id);
        verify(studentRepository, times(1)).deleteById(id);
    }
}

