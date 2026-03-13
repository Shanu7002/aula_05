package com.atividade.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atividade.cadastro.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String listAllStudents(Model model) {
        model.addAttribute("students", studentService.listAllStudents());
        return "main/home";
    }
}
