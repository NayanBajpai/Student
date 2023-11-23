package com.example.Student.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;

@DataJpaTest
class StudentEntityTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testSaveAndRetrieveStudent() {
        
        Student student = new Student("John", 20L, 50000L);

        Student savedStudent = entityManager.persistAndFlush(student);

        assertNotNull(savedStudent.getId());
        assertEquals(student.getName(), savedStudent.getName());

        Student retrievedStudent = studentRepository.findById(savedStudent.getId()).orElse(null);
        assertNotNull(retrievedStudent);
        assertEquals(savedStudent.getId(), retrievedStudent.getId());
        assertEquals(student.getName(), retrievedStudent.getName());
    }

    @Test
    void testUpdateStudent() {
        
        Student student = new Student("John", 20L, 50000L);
        Student savedStudent = entityManager.persistAndFlush(student);

        savedStudent.setName("Jane");
        Student updatedStudent = entityManager.persistAndFlush(savedStudent);

        assertEquals("Jane", updatedStudent.getName());

        Student retrievedStudent = studentRepository.findById(updatedStudent.getId()).orElse(null);
        assertNotNull(retrievedStudent);
        assertEquals("Jane", retrievedStudent.getName());
    }

//    @Test
//    void testDeleteStudent() {
//        
//        Student student = new Student("John", 20L, 50000L);
//        Student savedStudent = entityManager.persistAndFlush(student);
//
//        entityManager.remove(savedStudent);
//
//        assertFalse(entityManager.contains(savedStudent));
//
//        Student retrievedStudent = studentRepository.findById(savedStudent.getId()).orElse(null);
//        assertNull(retrievedStudent);
//    }
}

