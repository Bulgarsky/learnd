package com.example.market.models;

import com.example.market.enumm.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name="order_list")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String orderNo;

    @ManyToOne(fetch =  FetchType.EAGER, optional = false)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person person;

    private int count;

    private float price;

    private LocalDateTime dateTime;

    private Status status;

    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }

    public Order(String orderNo, Product product, Person person, int count, float price, Status status) {
        this.orderNo = orderNo;
        this.product = product;
        this.person = person;
        this.count = count;
        this.price = price;
        this.status = status;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }
    public String getOrderNo() {
        return orderNo;
    }
    public Product getProduct() {
        return product;
    }
    public Person getPerson() {
        return person;
    }
    public int getCount() {
        return count;
    }
    public float getPrice() {
        return price;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }
    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setPrice(float totalPrice) {
        this.price = totalPrice;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

}
