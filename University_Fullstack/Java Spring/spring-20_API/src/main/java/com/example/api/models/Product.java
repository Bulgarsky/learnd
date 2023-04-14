package com.example.api.models;

import jakarta.persistence.*;

@Entity
@Table(name="product_list")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title")
    private String title;
    @Column(name="price")
    private float price;

    public Product(String title, float price) {
        this.title = title;
        this.price = price;
    }
    public Product(){

    }

    //    public Product(int id, String title, float price) {
//        this.title = title;
//        this.price = price;
//    }
//    public Product() {}

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public float getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}
