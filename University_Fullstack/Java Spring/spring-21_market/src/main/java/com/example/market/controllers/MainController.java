package com.example.market.controllers;

import com.example.market.models.Person;
import com.example.market.security.PersonDetails;
import com.example.market.services.PersonService;
import com.example.market.services.ProductService;
import com.example.market.util.PersonValidate;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private  final PersonValidate personValidate;
    private final PersonService personService;
    private final ProductService productService;
    public MainController(PersonValidate personValidate, PersonService personService, ProductService productService) {
        this.personValidate = personValidate;
        this.personService = personService;
        this.productService = productService;
    }

    @GetMapping("/account")
    public String index(Model model){
        //получаем obj Auth -> w/ SpringContextHolder обращаемся к контексту и на нем вызываем метод Auth. Из сессии получаемп obj, которйы был положен в данную сессию после аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        //получение роли
        String role = personDetails.getPerson().getRole();
        if(role.equals("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        //данные для теста
        System.out.println("user ID: "+personDetails.getPerson().getId());
        System.out.println("user login: "+personDetails.getPerson().getLogin());
        System.out.println("user password: "+personDetails.getPerson().getPassword());
        System.out.println("user role: "+personDetails.getPerson().getRole());
        System.out.println(personDetails);
        //
        model.addAttribute("products", productService.getAllProduct());
        return "user/index";
    }

    //регистрация
    @GetMapping("/reg")
    public String registration(@ModelAttribute("person") Person person){
        return "reg";
    }
    @PostMapping("/reg")
    public String registrationResult(
            @ModelAttribute("person")@Valid Person person,
            BindingResult bindingResult){

        personValidate.validate(person, bindingResult);
        if (bindingResult.hasErrors()){
            return "reg";
        }
        personService.register(person);
        return "redirect:/account";
    }

    @GetMapping("/account/product/info/{id}")
    public String productInfo(@PathVariable("id") int id, Model model){
        model.addAttribute("product", productService.getProductId(id));
        return "/user/info";
    }

}

