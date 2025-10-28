package com.example.annotations.service;

import com.example.annotations.model.Student;
import com.example.annotations.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> addStudents(List<Student> students) {
        return studentRepository.saveAll(students);
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public boolean updateStudent(long id, Student request) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id: " + id + " not present"));

        student.setName(request.getName());
        student.setCollege(request.getCollege());
        studentRepository.save(student);
        return true;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

}
