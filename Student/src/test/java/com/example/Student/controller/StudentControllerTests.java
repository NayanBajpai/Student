package com.example.Student.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Student.controller.StudentController;
import com.example.Student.entity.Student;
import com.example.Student.service.StudentService;

class StudentControllerTests {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Mock
    private Model model;

    @Test
    void testListStudents() {
        
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", 20L, 50000L));
        students.add(new Student("Jane", 22L, 60000L));

        when(studentService.getAllStudents()).thenReturn(students);

        String viewName = studentController.listStudents(model);

        assertEquals("students", viewName);
        verify(model, times(1)).addAttribute("students", students);
    }

    @Test
    void testFindUserById() {
        
        Long id = 1L;
        Student student = new Student("John", 20L, 50000L);

        when(studentService.findById(id)).thenReturn(Optional.of(student));

        Optional<Student> result = studentController.findUserById(id);

        assertTrue(result.isPresent());
        assertEquals("John", result.get().getName());
    }

    @Test
    void testSaveStudent() {
        
        Student studentToSave = new Student("John", 20L, 50000L);
        Student savedStudent = new Student("John", 20L, 50000L);

        when(studentService.saveStudent(studentToSave)).thenReturn(savedStudent);

        Student result = studentController.saveStudent(studentToSave);

        assertEquals("John", result.getName());
        assertEquals(20L, result.getAge());
        assertEquals(50000L, result.getSalary());
    }

    @Test
    void testUpdateStudent() {
        
        Student studentToUpdate = new Student("John", 20L, 50000L);
        Student updatedStudent = new Student("John", 22L, 60000L);

        when(studentService.updateStudent(studentToUpdate)).thenReturn(updatedStudent);

        Student result = studentController.updateStudent(studentToUpdate);

        assertEquals("John", result.getName());
        assertEquals(22L, result.getAge());
        assertEquals(60000L, result.getSalary());
    }

    @Test
    void testDeleteStudent() {
        
        Long id = 1L;
        studentController.deleteStudent(id);
        verify(studentService, times(1)).deleteStudent(id);
    }
}

