package com.example.market.controllers;

import com.example.market.models.Person;
import com.example.market.security.PersonDetails;
import com.example.market.services.CategoryService;
import com.example.market.services.ProductService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public AuthenticationController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    //Аутентификация
    @GetMapping("/auth")
    public String login(){
        return "auth";
    }

    //вывод товаров
    @GetMapping("/index")
    public String index(Model model){
        Person currentPerson = getCurrentAuthPerson();
        model.addAttribute("userAuth", currentPerson);
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("categoryList", categoryService.getCategoryList());
        //получение роли
        String role = currentPerson.getRole();
        if (role.isEmpty()) {
            return "/NotAuthIndex";
        } else {
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
        }

        //вернуть рекламу
        //вернуть категории
        return "/404";
    }
    @GetMapping("/")
    public String defaultIndex(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "/NotAuthIndex";
    }
    public Person getCurrentAuthPerson(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getPerson();
    }
}
