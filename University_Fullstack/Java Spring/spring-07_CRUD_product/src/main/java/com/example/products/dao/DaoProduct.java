package com.example.products.dao;

import com.example.products.enumm.Provider;
import com.example.products.models.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoProduct {
    private int id;
    private List<Product> productList = new ArrayList<>();

    // create obj and add to ArrayList
//    public void addProduct(String name, float price, String weight, Provider provider) {
//        productList.add(new Product(++id, name, price, weight, provider));
//    }
    public void addProduct(Product product) {
        productList.add(product);
        product.setId(++id);
    }

    //getter: all product from ArrayList
    public List<Product> getProductList() {
        return productList;
    }

    public Product getProductId(int id) {
        for (Product item: productList) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
        //lambda
        //return productList.stream().filter(product -> product.getId() == id).findAny().orElse(null);
    }

    //найти товар по id и внести изменения полученные из формы
    public void updateProduct(int id, Product product) {
        Product productUpdate = getProductId(id);
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        productUpdate.setWeight(product.getWeight());
        productUpdate.setProvider(product.getProvider());
    }

}
