package com.samir.hibernatedemo.service;

import com.samir.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    String deleteStudent(Long studentId);
}
