package com.example.market.models;

import com.example.market.enumm.ShippingAddressStatus;
import jakarta.persistence.*;

@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //valid 6 цифр
    private String zip;
    //только буквы
    private String country;
    //только буквы
    private String state;
    //только буквы
    private String city;
    private String street;
    private String building;
    private String apartment;
    private ShippingAddressStatus addressStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Person person;

    //constructors
    public ShippingAddress() {

    }

    public ShippingAddress(String zip, String country, String state, String city, String street, String building, String apartment, ShippingAddressStatus addressStatus, Person person) {
        this.zip = zip;
        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
        this.addressStatus = addressStatus;
        this.person = person;
    }
//setters

    public void setId(int id) {
        this.id = id;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setState(String state) {
        this.state = state;
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
    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    public void setAddressStatus(ShippingAddressStatus addressStatus) {
        this.addressStatus = addressStatus;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getZip() {
        return zip;
    }
    public String getCountry() {
        return country;
    }
    public String getState() {
        return state;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getBuilding() {
        return building;
    }
    public String getApartment() {
        return apartment;
    }

    public Person getPerson() {
        return person;
    }

    public ShippingAddressStatus getAddressStatus() {
        return addressStatus;
    }
}
