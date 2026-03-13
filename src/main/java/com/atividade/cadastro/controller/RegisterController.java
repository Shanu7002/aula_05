package com.atividade.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class RegisterController {
    @GetMapping("/new")
    public String newStudent() {
        return "";
    }

    @PostMapping("/saveNew")
    public String saveNewStudent() {
        return "";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id) {
        return "";
    }

    @PostMapping("/saveEdit")
    public String saveEditStudent() {
        return "";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return "";
    }

}
