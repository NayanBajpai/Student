package com.example.Student.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.Student.entity.Student;

@DataJpaTest
class StudentRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testFindAll() {
        
        Student john = new Student("John", 20L, 50000L);
        Student jane = new Student("Jane", 22L, 60000L);
        entityManager.persist(john);
        entityManager.persist(jane);
        entityManager.flush();

        List<Student> students = studentRepository.findAll();

        assertEquals(2, students.size());
        assertTrue(students.contains(john));
        assertTrue(students.contains(jane));
    }

    @Test
    void testFindById() {
        
        Student john = new Student("John", 20L, 50000L);
        entityManager.persist(john);
        entityManager.flush();

        Optional<Student> result = studentRepository.findById(john.getId());

        assertTrue(result.isPresent());
        assertEquals(john.getName(), result.get().getName());
    }

    @Test
    void testSave() {
        
        Student studentToSave = new Student("John", 20L, 50000L);

        Student savedStudent = studentRepository.save(studentToSave);

        assertNotNull(savedStudent.getId());
        assertEquals(studentToSave.getName(), savedStudent.getName());
    }

    @SuppressWarnings("unchecked")
	@Test
    void testDeleteById() {
        
        Student john = new Student("John", 20L, 50000L);
        entityManager.persist(john);
        entityManager.flush();

        studentRepository.deleteById(john.getId());

        assertFalse(((List<Student>) entityManager).contains(john));
    }
}

