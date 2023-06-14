package com.example.market.controllers;

import com.example.market.models.*;
import com.example.market.services.*;
import com.example.market.util.PersonValidate;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final PersonValidate personValidate;
    private final PersonService personService;
    private final CategoryService categoryService;
    private final AuthenticationController authController;
    private final OrderService orderService;
    private final ProductService productService;

    public MainController(PersonValidate personValidate, PersonService personService, CategoryService categoryService, AuthenticationController authController, OrderService orderService, ProductService productService) {
        this.personValidate = personValidate;
        this.personService = personService;
        this.categoryService = categoryService;
        this.authController = authController;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/404")
    public String page404(){
        return "/404";
    }

    //личный кабинет после авторизации
    @GetMapping("/my")
    public String index(Model model){
        Person currentPerson = authController.getCurrentAuthPerson();
        model.addAttribute("userAuth", currentPerson);

        switch (currentPerson.getRole()) {
            case "ROLE_USER" -> {
                return "/user/main";
            }
            case "ROLE_ADMIN" -> {
                //Вывод временных данных для заполнения представления
                model.addAttribute("enabledCategory", categoryService.getActiveCategoryList());
                model.addAttribute("userCount", personService.getAllPerson().size());
                //model.addAttribute("activeOrder", orderService.findOrderByStatusActive().size());
                model.addAttribute("productCount", productService.getAllProduct().size());
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

