package com.example.manytomany.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;

    @ManyToMany
    @JoinTable(name="student_university", joinColumns = @JoinColumn(name="student_id"), inverseJoinColumns = @JoinColumn(name="university_id"))
    private List<University> universities;

}
