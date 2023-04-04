package com.example.manytomany.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(name = "student_university", joinColumns = @JoinColumn(name="university_id"), inverseJoinColumns = @JoinColumn(name ="student_id"))
    private List<Student> students;
}
