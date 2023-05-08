package com.example.market.controllers;

import com.example.market.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    private final ProductService productService;

    public AuthenticationController(ProductService productService) {
        this.productService = productService;
    }

    //Аутентификация
    @GetMapping("/auth")
    public String login(){
        return "auth";
    }

    //вывод товаров
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }

}
