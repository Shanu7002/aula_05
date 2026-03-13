package com.atividade.cadastro.repository;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.atividade.cadastro.model.Student;
import com.atividade.cadastro.model.StudentClassEnum;

@Repository
public class StudentRepository {

    private final Map<Long, Student> students = new LinkedHashMap<>();
    private Long nextId = 1L;

    public void saveStudent(String name, StudentClassEnum classRoom, LocalDate birthday) {
        Student student = new Student(name, classRoom, birthday);
        this.save(student);
    }

    private Student save(Student student) {
        if (student.getId() == null) {
            student.setId(nextId++);
        }
        students.put(student.getId(), student);
        return student;
    }

    public Optional<Student> findByid(Long id) {
        return Optional.ofNullable(students.get(id));
    }
}
