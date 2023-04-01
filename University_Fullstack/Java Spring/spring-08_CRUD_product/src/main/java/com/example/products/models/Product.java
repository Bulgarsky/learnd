package com.example.products.models;

import com.example.products.enumm.Provider;

public class Product {
    private int id;
    private String name;
    private float price;
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