package com.example.market.models;

import jakarta.persistence.*;


@Entity
@Table(name="product_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "person_id")
    private int personId;

    @Column(name = "product_id")
    private int productId;

    public Cart(int personId, int productId) {
        this.personId = personId;
        this.productId = productId;
    }
    public Cart() {

    }


    public int getId() {
        return id;
    }
    public int getPersonId() {
        return personId;
    }
    public int getProductId() {
        return productId;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setPersonId(int personId) {
        this.personId = personId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }

}
