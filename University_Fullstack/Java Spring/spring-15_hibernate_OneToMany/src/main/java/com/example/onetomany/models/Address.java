package com.example.onetomany.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String street;
    private String building;
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private List<Person> tenants;

    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getBuilding() {
        return building;
    }
    public List<Person> getTenants() {
        return tenants;
    }
    public int getId() {
        return id;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setBuilding(String building) {
        this.building = building;
    }
    public void setTenants(List<Person> tenants) {
        this.tenants = tenants;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Address() {}

}
