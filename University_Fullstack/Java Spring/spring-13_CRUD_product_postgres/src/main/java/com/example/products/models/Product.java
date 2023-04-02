package com.example.products.models;


import com.example.products.enumm.Provider;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotEmpty;


@Entity(name = "product_list")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Наименование не может быть пустым")
    //@Pattern(regexp = "[А-Яа-я]")
    @Size(min = 3, max = 15, message = "Наименование от 3 до 15 символов")
    @Column(name="name", length = 15, nullable = false, columnDefinition = "text")
    private String name;
    @NotNull(message = "Цена обязательна к заполнению")
    @Min(value = 10, message = "Минимальная цена 10")
    @Column(name="price", nullable = false, columnDefinition = "float")
    private float price;
    @NotNull(message = "Вес не может быть пустым")
    @Min(value = 50, message = "Мин.вес 50 гр.")
    @Max(value = 5000, message = "Макс.вес 5000 гр.")
    @Column(name="weight", nullable = false, columnDefinition = "float")
    private float weight;

    private Provider provider;

    public Product(){}
    public Product(int id, String name, float price, float weight, Provider provider) {
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
    public float getWeight() {
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
    public void setWeight(float weight) {
        this.weight = weight;
    }
    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}