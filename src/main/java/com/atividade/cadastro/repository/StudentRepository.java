package com.atividade.cadastro.repository;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.atividade.cadastro.model.Student;

@Repository
public class StudentRepository {

    private final Map<Long, Student> students = new LinkedHashMap<>();
    private Long nextId = 1L;

    public void saveStudent(Student student) {
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

    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }
    
    public String deleteStudent(Student student) {
        students.remove(student.getId());
        return student.getName();
    }
}
