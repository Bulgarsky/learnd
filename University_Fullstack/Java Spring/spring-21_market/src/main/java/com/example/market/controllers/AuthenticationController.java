package com.example.market.controllers;

import com.example.market.security.PersonDetails;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @GetMapping("/index")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        //получение роли
        String role = personDetails.getPerson().getRole();
        model.addAttribute("products", productService.getAllProduct());
        switch (role) {
            case "ROLE_USER" -> {

                return "user/userIndex";
            }
            case "ROLE_ADMIN" -> {
                return "/admin/terminal";
            }
            case "ROLE_SELLER" -> {
                return "/404";
            }
        }
        //вернуть рекламу
        //вернуть категории
        return "404";
    }
    @GetMapping("/")
    public String defaultIndex(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }


}
