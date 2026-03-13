package com.atividade.cadastro.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atividade.cadastro.model.Student;
import com.atividade.cadastro.model.StudentClassEnum;
import com.atividade.cadastro.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(String name, StudentClassEnum classRoom, LocalDate birthday) {
        try {
            studentRepository.saveStudent(name, classRoom, birthday);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findByid(id);
    }

    public List<Student> listAllStudents() {
        return studentRepository.findAll();
    } 
}