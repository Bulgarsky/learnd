package com.example.users.models;


import javax.validation.constraints.*;

public class User {
    //model fields
    private int id;
    @NotEmpty(message = "Фамилия не может быть пустой")
    @Size(min = 2, max = 30, message = "От 2 до 15 символов")  //@Min() @Max()
    private String lastName;
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 30, message = "От 2 до 15 символов")
    private String firstName;
    private String middleName;
    @Min(value = 18, message = "Возраст не может меньше 18")
    private int age;
    @NotEmpty(message = "Почта обязательна к заполнению")
    @Email(message = "Введите корректную почту")
    private String email;
    @NotEmpty(message = "Телефон должен быть заполнен")
    @Pattern(regexp = "^((\\+7|7|8)+([0-9]){10})$", message = "Введите номер телефона в формате: +7/7/8(0123456789)")
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
