package com.example.annotations.service;

import com.example.annotations.model.Student;
import com.example.annotations.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @CacheEvict(value = "students", allEntries = true)
    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    @Cacheable("students")
    public List<Student> getStudents() {
        log.info("Fetching the data from db");
        return studentRepository.findAll();
    }

    @CacheEvict(value = "students", allEntries = true)
    public boolean updateStudent(long id, Student request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " not present"));

        student.setName(request.getName());
        student.setCollege(request.getCollege());
        studentRepository.save(student);
        return true;
    }

    @CacheEvict(value = "students", allEntries = true)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
