package com.example.users.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity(name="user_site")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "От 2 до 15 символов")
    @Column(name = "lastName", length = 30, nullable = false, columnDefinition = "text")
    private String lastName;

    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 15, message = "От 2 до 15 символов")
    @Column(name = "firstName", length = 15, nullable = false, columnDefinition = "text")
    private String firstName;

    @Column(name = "middleName", length = 25, nullable = true, columnDefinition = "text")
    private String middleName;

    @Min(value = 18, message = "Возраст не может меньше 18")
    @Column(name = "age", length = 5, nullable = false, columnDefinition = "int")
    private int age;

    @NotEmpty(message = "Почта обязательна к заполнению")
    @Email(message = "Введите корректную почту")
    @Column(name = "email", length = 50, nullable = false, columnDefinition = "text", unique = true)
    private String email;

    @NotEmpty(message = "Телефон должен быть заполнен")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите номер телефона в формате: +7/7/8(0123456789)")
    @Column(name = "phoneNo", length = 12, nullable = false, columnDefinition = "text", unique = true)
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

}
