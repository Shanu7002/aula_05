package com.atividade.cadastro.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atividade.cadastro.model.Student;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @GetMapping("/new")
    public String newStudent(Model model) {
        model.addAttribute("student", new Student());

        LocalDate today = LocalDate.now();
        Date maxDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        model.addAttribute("maxBirthday", maxDate);

        return "main/register";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id) {
        return "";
    }

    @PostMapping("/save")
    public String saveStudent() {
        return "";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return "";
    }

}
