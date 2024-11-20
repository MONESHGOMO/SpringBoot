package com.GomoCodes.Gomo.controller;

import com.GomoCodes.Gomo.entity.Student;
import com.GomoCodes.Gomo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // POST: Create Student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {  // @RequestBody Converts JSON to a Student Object using library  like Jackson
        return studentService.saveStudent(student);
    }

    // GET: Retrieve All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // GET: Retrieve Student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // PUT: Update Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent != null) {
            existingStudent.setName(studentDetails.getName());
            existingStudent.setEmail(studentDetails.getEmail());
            existingStudent.setDob(studentDetails.getDob());
            return studentService.saveStudent(existingStudent);
        }
        return null;
    }

    // DELETE: Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }

}
