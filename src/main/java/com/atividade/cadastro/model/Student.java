package com.atividade.cadastro.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {
    private Long id;

    @NotBlank(message = "Student must have a name.")
    @Size(min = 3, max = 100, message = "Student name must have between 3 and 100 characteres.")
    private String name;

    @NotNull(message = "Student must have a classroom.")
    private StudentClassEnum classRoom;

    @NotNull(message = "Student must have a birthday.")
    private LocalDate birthday;

    private LocalDate creationDate = LocalDate.now();

    public Student() { }

    public Student(String name, StudentClassEnum classRoom, LocalDate birthday) {
        this.name = name;
        this.classRoom = classRoom;
        this.birthday = birthday;
    }

    public Long getId() {
        return id;
    }

    public Student setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public StudentClassEnum getClassRoom() {
        return classRoom;
    }

    public Student setClassRoom(StudentClassEnum classRoom) {
        this.classRoom = classRoom;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Student setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }
    
    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Student setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
        return this;
    }
}
