package com.GomoCodes.Gomo.service;

import com.GomoCodes.Gomo.entity.Student;
import com.GomoCodes.Gomo.repository.StudentRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // Create or Update
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get All Students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get Student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Delete Student
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student removed with id " + id;
    }
}
