package com.example.market.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> product;

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public List<Product> getProduct() {
        return product;
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
}
