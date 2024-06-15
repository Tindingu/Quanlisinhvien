package com.example.demoMVC.service;

import com.example.demoMVC.entity.Student;


import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

    public List<Student> getAllStudentsNotFirstName(String name);

}
