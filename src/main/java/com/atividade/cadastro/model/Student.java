package com.atividade.cadastro.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Student {
    private Long id;

    @NotBlank(message = "Student must have a name.")
    @Size(min = 3, max = 100, message = "Student name must have between 3 and 100 characteres.")
    private String name;

    @NotBlank(message = "Student must have a classroom.")
    private StudentClassEnum classRoom;

    @NotBlank(message = "Student must have a birthday.")
    private Date birthday;

    private LocalDate creationDate = LocalDate.now();

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

    public StudentClassEnum getClassRomm() {
        return classRoom;
    }

    public Student setClassRoom(StudentClassEnum classRoom) {
        this.classRoom = classRoom;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Student setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }
    
    public LocalDate getCreationDate() {
        return creationDate;
    }
}
