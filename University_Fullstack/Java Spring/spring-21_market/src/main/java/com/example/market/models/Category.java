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
    @Column(name="is_enabled")
    private boolean is_Enabled = true;

    @Column(name="bootstrap_icon")
    private String icon = "bi bi-dot";

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

    public String getIcon() {
        return icon;
    }

    public boolean isEnabled() {
        return is_Enabled;
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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setEnabled(boolean enabled) {
        is_Enabled = enabled;
    }
}
