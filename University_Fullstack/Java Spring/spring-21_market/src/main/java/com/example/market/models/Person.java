package com.example.market.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="user_list")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Логин не может быть пустым")
    @Size(min=5, max=15, message="Логин должен состоять от 5 до 15 символов")
    @Column(name="login")
    private String login;

    @NotEmpty(message = "Пароль не может быть пустым")
    @Column(name="password")
    //@Pattern()
    private String password;

    @Column(name="role")
    private String role;


    @ManyToMany()
    @JoinTable(name="product_cart", joinColumns = @JoinColumn(name="person_id"), inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> productList;

    @OneToMany(mappedBy="person", fetch = FetchType.EAGER)
    private List<Order> orderList;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<ShippingAddress> shippingAddressList;


    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getRole() {
        return role;
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
    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(login, person.login) && Objects.equals(password, person.password);
    }

    //данный метод преобразует объект класса в число
    @Override
    public int hashCode() {
        return Objects.hash(id, login, password);
    }
}