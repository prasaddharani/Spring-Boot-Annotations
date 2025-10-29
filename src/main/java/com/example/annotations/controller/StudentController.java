package com.example.annotations.controller;

import com.example.annotations.model.Student;
import com.example.annotations.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public List<Student> createStudents(@RequestBody List<Student> students) {
        return studentService.addStudents(students);
    }

    @GetMapping
    public List<Student> getStudents() {
        log.info("GetStudents api call");
        return studentService.getStudents();
    }

    @GetMapping("/search")
    public Student getStudentById(@RequestParam(name = "id", required = true) long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public boolean updateStudent(@PathVariable long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
    }
}
