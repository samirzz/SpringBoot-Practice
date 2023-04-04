package com.samir.hibernatedemo.service.impl;

import com.samir.hibernatedemo.entity.Student;
import com.samir.hibernatedemo.repository.StudentRepository;
import com.samir.hibernatedemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student addStudent(Student student) {
        Student student1 = new Student();
        student1.setFullName(student.getFullName());
        student1.setEmail(student.getEmail());
        student1.setPassword(student.getPassword());
        student1.setDob(student.getDob());
        student1.setAddress(student.getAddress());
        student1.setAddedOn(student.getAddedOn());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> all = studentRepository.findAll();
        return all;
    }

    @Override
    public String deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Not Valid Id!!"));
        studentRepository.delete(student);
        return "Student Deleted successfully!!".concat(student.getFullName());
    }
}
