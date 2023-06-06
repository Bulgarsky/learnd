package com.example.market.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message="Название категории нужно заполнить")
    private String title;
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> product;

    public Category() {
    }

    public Category(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public List<Product> getProduct() {
        return product;
    }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public void setDescription(String description){
        this.description=description;
    }
}
