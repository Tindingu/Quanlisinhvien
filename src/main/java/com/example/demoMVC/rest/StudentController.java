package com.example.demoMVC.rest;

import com.example.demoMVC.entity.Student;
import com.example.demoMVC.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String listAll(Model model) {
        List<Student> students=studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/students";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("student", new Student());
        return "students/student-form";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute ("student") Student student) {
        studentService.updateStudent(student);
        return "redirect:/students/list";
    }
    @GetMapping("/update")
    public String update(@RequestParam("id") Integer id,Model model) {
        Student student =studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "/students/student-form";
    }
    @GetMapping("/delete")
    @Transactional
    public String delete(@RequestParam("id") Integer id) {
        Student student =studentService.getStudentById(id);
        studentService.deleteStudentById(id);
        return "redirect:/students/list";
    }
}
