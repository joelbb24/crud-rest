package com.jardevs.learning.demo.controller;


import com.jardevs.learning.demo.model.Student;
import com.jardevs.learning.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping("/students/{id}")
    public void postStudentById(@RequestBody Student student) {
        repo.save(student);
    }

    @PutMapping("/students/{id}")
    public void putById(@RequestBody Student student, @PathVariable Long id) {
        repo.findById(id).map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            student1.setCourses(student.getCourses());
            return student1;
        }).orElse(repo.save(student));
    }

    @DeleteMapping("/students")
    public void deleteAll() {
        repo.deleteAll();
    }

    @DeleteMapping("/students/{id}")
    public void deleteById(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
