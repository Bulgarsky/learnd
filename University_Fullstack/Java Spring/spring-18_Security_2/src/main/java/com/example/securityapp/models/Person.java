package com.example.securityapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user_list")
public class Person {

    @Id
    @Column(name="id")
    private int id;

    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min=5, max=15, message="Логин должен состоять от 5 до 15 символов")
    @Column(name="login")
    private String login;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name="password")
    private String password;

    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
