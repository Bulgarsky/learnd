package com.example.session_cookies.models;

public class Cart {
    private String productName;
    private int amount;
    private float price;

    public Cart() {

    }

    public Cart(String productName, int amount, float price) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }
    public int getAmount() {
        return amount;
    }
    public float getPrice() {
        return price;
    }
}
