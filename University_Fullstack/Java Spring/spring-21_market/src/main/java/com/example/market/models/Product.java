package com.example.market.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="title", nullable = false, columnDefinition = "text", unique = true)
    @NotEmpty(message = "Наименование не может быть пустым")
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    @NotEmpty(message = "Необходимо заполнить описание")
    private String description;

    @Column(name="price", nullable = false)
    @Min(value=1, message = "Мин.цена не может быть отрицательой или мнеьше 0")
    private float price;

    @Column(name="warehouse", nullable = false)
    @NotEmpty(message = "Укажите склад хранения")
    private String warehouse;

    @Column(name="seller", nullable = false)
    @NotEmpty(message = "Укажите продавца")
    private  String seller;

    @ManyToOne(optional = false)
    private Category category;


    //хранение наименований фото для каждого товара
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> imageList = new ArrayList<>();

    //добавление фото в лист конкретного товару
    public void addImageToProduct(Image image){
        image.setProduct(this);
        imageList.add(image);
    }

    //метод будет заполнять поле даты и времени при создании объекта класса
    private LocalDateTime dateTime;
    @PrePersist
    private void init(){
        dateTime = LocalDateTime.now();
    }

    @ManyToMany()
    @JoinTable(name="product_cart", joinColumns = @JoinColumn(name="product_id"), inverseJoinColumns = @JoinColumn(name="person_id"))
    private List<Person> personList;

    @OneToMany(mappedBy="product", fetch = FetchType.EAGER)
    private List<Order> orderList;

    public Product(String title, String description, float price, String warehouse, String seller, Category category, List<Image> imageList, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.warehouse = warehouse;
        this.seller = seller;
        this.category = category;
        this.imageList = imageList;
        this.dateTime = dateTime;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public float getPrice() {
        return price;
    }
    public String getWarehouse() {
        return warehouse;
    }
    public String getSeller() {
        return seller;
    }
    public Category getCategory() {
        return category;
    }
    public List<Image> getImageList() {
        return imageList;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
