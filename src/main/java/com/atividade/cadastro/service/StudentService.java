package com.atividade.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.atividade.cadastro.model.Student;
import com.atividade.cadastro.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        try {
            studentRepository.saveStudent(student);
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

    public String deleteStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findByid(id);
        if (optionalStudent.isEmpty()) {
            throw new Error("Student not found.");
        }
        Student student = optionalStudent.get();
        String name = studentRepository.deleteStudent(student);
        return name;
    }
}