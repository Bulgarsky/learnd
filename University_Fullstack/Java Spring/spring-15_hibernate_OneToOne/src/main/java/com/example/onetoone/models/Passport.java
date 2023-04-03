package com.example.onetoone.models;

import jakarta.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String series;
    private String number;
    @OneToOne(mappedBy = "passport") //указываем таблицу для связи
    private Citizen owner;

    //getters
    public int getId() {
        return id;
    }
    public String getSeries() {
        return series;
    }
    public String getNumber() {
        return number;
    }
    public Citizen getOwner() {
        return owner;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public void setOwner(Citizen owner) {
        this.owner = owner;
    }
}
