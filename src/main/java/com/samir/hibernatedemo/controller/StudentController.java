package com.samir.hibernatedemo.controller;

import com.samir.hibernatedemo.entity.Student;
import com.samir.hibernatedemo.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(value = "/add/student")
    public Student addStudent(@RequestBody Student student) {
        log.info("Adding student :: {} ", student);
        return studentService.addStudent(student);
    }

    @GetMapping(value = "/get-all")
    public List<Student> getAllStudents() {
        log.info("get all student");
        return studentService.getAllStudents();
    }

    @DeleteMapping(value = "/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
        log.info("delete student :: [{}]", studentId);
        return studentService.deleteStudent(studentId);
    }
}
