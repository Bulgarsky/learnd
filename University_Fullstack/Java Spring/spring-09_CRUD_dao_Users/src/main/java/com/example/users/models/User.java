package com.example.users.models;

public class User {
    //model fields
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int age;
    private String email;
    private String phoneNo;

    //model constructors
    public User(){}
    public User(int id, String lastName, String firstName, String middleName, int age, String email, String phoneNo) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.age = age;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    //model getters
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
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }

    //model setters

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

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
