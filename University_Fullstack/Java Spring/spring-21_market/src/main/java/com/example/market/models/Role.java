//package com.example.market.models;
//
//import jakarta.persistence.*;
//
//import java.util.List;
//
//@Entity
//public class Role {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    private String role;
//    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
//    private List<Person> person;
//
//    public int getId() {
//        return id;
//    }
//    public String getRole() {
//        return role;
//    }
//    public List<Person> getPerson() {
//        return person;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//    public void setRole(String role) {
//        this.role = role;
//    }
//    public void setPerson(List<Person> person) {
//        this.person = person;
//    }
//}

