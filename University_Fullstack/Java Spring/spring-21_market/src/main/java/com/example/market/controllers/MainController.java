package com.example.market.controllers;

import com.example.market.enumm.Status;
import com.example.market.models.*;
import com.example.market.repositories.ProductRepository;
import com.example.market.security.PersonDetails;
import com.example.market.services.CartService;
import com.example.market.services.OrderService;
import com.example.market.services.PersonService;
import com.example.market.services.ProductService;
import com.example.market.util.PersonValidate;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {
    private final PersonValidate personValidate;
    private final PersonService personService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final CartService cartService;
    private final OrderService orderService;
    public MainController(PersonValidate personValidate, PersonService personService, ProductService productService, ProductRepository productRepository, CartService cartService, OrderService orderService) {
        this.personValidate = personValidate;
        this.personService = personService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping("/404")
    public String page404(){
        return "/404";
    }

    //личный кабинет после авторизации
    @GetMapping("/my")
    public String index(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        System.out.println("Проверка аккаунта после Auth");

//        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("userAuth", personDetails.getPerson());

        //получение роли
        String role = personDetails.getPerson().getRole();
        System.out.println("user login: " +personDetails.getPerson().getLogin());
        System.out.println("user role: " + personDetails.getPerson().getRole());
        switch (role) {
            case "ROLE_USER" -> {
                return "/user/main";
            }
            case "ROLE_ADMIN" -> {
                return "/admin/terminal";
            }
            case "ROLE_SELLER" -> {
                return "/404";
            }
        }

        return "/404";
    }

    //Регистрация get
    @GetMapping("/reg")
    public String registration(@ModelAttribute("person") Person person){
        return "reg";
    }
    //Регистрация post
    @PostMapping("/reg")
    public String registrationResult(
            @ModelAttribute("person")@Valid Person person,
            BindingResult bindingResult){

        personValidate.validate(person, bindingResult);
        if (bindingResult.hasErrors()){
            return "reg";
        }
        personService.register(person);
        //редирект в личный кабинет - доделать
        return "redirect:/my";
    }


    @GetMapping("/favorites")
    public String fav(){
        return "fav";
    }

    @GetMapping("/order/confirm")
    public String orderConfirm(){
        return "404";
    }
    @GetMapping("/admin/category")
    public String category(){
        return "404";
    }
}

