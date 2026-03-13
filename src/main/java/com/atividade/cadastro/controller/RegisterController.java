package com.atividade.cadastro.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atividade.cadastro.model.Student;
import com.atividade.cadastro.service.StudentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final StudentService studentService;

    public RegisterController(StudentService studentService) {
        this.studentService = studentService;
    }

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
    public String saveStudent(@Valid Student student, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "main/register";
        }

        boolean isNew = student.getId() == null;

        if (!isNew) {
            studentService.findById(student.getId()).ifPresent(exist -> {
                student.setCreationDate(exist.getCreationDate());
            });
        }

        studentService.saveStudent(student.getName(), student.getClassRoom() ,student.getBirthday());

        if (isNew) {
            redirectAttributes.addFlashAttribute("mensagem", "Student created with sucess!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Student edited with sucess!");
        }
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        String name = studentService.deleteStudent(id);
        redirectAttributes.addFlashAttribute("mensagens", "Student " + name + " deleted with sucess.");
        return "redirect:/students";
    }

}
