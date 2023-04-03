package com.example.onetoone.models;

import jakarta.persistence.*;

@Entity
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id", unique = true)
    private Passport passport;

    public Citizen(String lastName, String firstName, String middleName, Passport passport) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.passport = passport;
    }
    public Citizen() {}

    //getters
    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public Passport getPassport() {
        return passport;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
