package com.example.annotations.controller;

import com.example.annotations.model.Student;
import com.example.annotations.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return studentService.getStudents();
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
