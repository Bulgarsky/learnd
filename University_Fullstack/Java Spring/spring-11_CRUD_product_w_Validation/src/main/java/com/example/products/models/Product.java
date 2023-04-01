package com.example.products.models;

import com.example.products.enumm.Provider;

import javax.validation.constraints.*;


public class Product {
    private int id;
    @NotEmpty(message = "Наименование не может быть пустым")
    //@Pattern(regexp = "[А-Яа-я]")
    @Size(min = 3, max = 15, message = "Наименование от 3 до 15 символов")
    private String name;
    @NotNull(message = "Цена обязательна к заполнению")
    @Min(value = 10, message = "Минимальная цена 10")
    private float price;
    @NotEmpty(message = "Вес обязателен к заполнению")
    @Min(value = 50, message = "Мин.вес 50 гр.")
    @Max(value = 5000, message = "Макс.вес 5000 гр.")
    private String weight;
    private Provider provider;

    public Product(){}
    public Product(int id, String name, float price, String weight, Provider provider) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.provider = provider;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
    public String getWeight() {
        return weight;
    }
    public Provider getProvider() {
        return provider;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}