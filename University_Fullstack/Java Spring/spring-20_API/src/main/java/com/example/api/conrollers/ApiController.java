package com.example.api.conrollers;

import com.example.api.models.Product;
import com.example.api.repositories.ProductRepository;
import com.example.api.util.ProductErrorResponse;
import com.example.api.util.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller
@RestController
@RequestMapping("/api")
public class ApiController {
    private final ProductRepository productRepository;

    public ApiController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@ResponseBody
    @GetMapping("/info")
    public String getApiPrintInfo(){
        return "that api get back product information";
    }

    @GetMapping("/product")
    public List<Product> getProduct(){
        //ссылка на объект с листом. Jackson работает под копотом
        //list<Product> -> Jackson -> JSON
        System.out.println(productRepository.findAll());
        return  productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    //optional так как obj может быть найден, а может и нет.
    public Optional<Product> getProductId(@PathVariable("id") int id){
        return productRepository.findById(id);
    }
    /*
    @GetMapping("/product/delete/{id}")
    public String deleteProductId(@PathVariable("id") int id){
        //System.out.println(productRepository.getById(id));
        productRepository.deleteById(id);
        return "Товар успешно удален";
    }
    */

    @GetMapping("/product/delete/{id}")
    public Product deleteProductId(@PathVariable("id") int id){
        //System.out.println(productRepository.getById(id));
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(ProductNotFoundException::new);
    }
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerException(ProductNotFoundException productNotFoundException){
        ProductErrorResponse response = new ProductErrorResponse("Не удалось найти товар по данному id");
        //not_found статус  в загаловке 404, response тело статуса
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/product/add")
    public String addProduct(
            @RequestParam("title") String title,
            @RequestParam("price") float price){
        Product addProduct = new Product(title, price);
        productRepository.save(addProduct);
        System.out.println("Добавлен товар с полями: "+title+", "+price);
        return "Товар добавлен";
        //add?title=Mouse&price=750
    }
}
