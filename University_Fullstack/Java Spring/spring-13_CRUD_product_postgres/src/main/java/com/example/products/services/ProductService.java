package com.example.products.services;

import com.example.products.models.Product;
import com.example.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //получить все продукты
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    //поиск по id и возврат объекта через контейнер(обертку) optional
    public Product getProductId(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        //select * frn product_list where id = {id}
        return optionalProduct.orElse(null);
    }

    //добавить продукт в таблицу продукт_лист
    @Transactional //(readOnly = false) default
    public void addProduct(Product product) {
        //insert into product_list (name, etc) values (, , , )
        productRepository.save(product);
    }

    //обновление продукта в бд
    @Transactional
    public void editProduct(int id, Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    //удаление
    @Transactional
    public void deleteProduct(int id) {
        //delete from product_list where id={id}
        productRepository.deleteById(id);
    }
}
