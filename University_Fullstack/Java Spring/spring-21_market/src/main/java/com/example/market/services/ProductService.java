package com.example.market.services;


import com.example.market.models.Category;
import com.example.market.models.Product;
import com.example.market.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //m getback all products
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    //m getback product w/ id
    public Product getProductId(int id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    //m save product w category
    @Transactional
    public void saveProduct(Product product, Category category){
        product.setCategory(category);
        productRepository.save(product);
    }

    //m update product info
    public void updateProduct(int id, Product product){
        product.setId(id);
        productRepository.save(product);
    }
    //m delete product w id
    @Transactional
    public void deleteProduct(int id){
        productRepository.deleteById(id);
    }
}
