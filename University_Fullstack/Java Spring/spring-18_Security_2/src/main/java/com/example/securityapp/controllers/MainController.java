package com.example.securityapp.controllers;

import com.example.securityapp.models.Person;
import com.example.securityapp.security.PersonDetails;
import com.example.securityapp.services.PersonService;
import com.example.securityapp.util.PersonValidate;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    private  final PersonValidate personValidate;
    private final PersonService personService;
    public MainController(PersonValidate personValidate, PersonService personService) {
        this.personValidate = personValidate;
        this.personService = personService;
    }

    @GetMapping("/index")
    public String index(){
        //получаем obj Auth -> w/ SpringContextHolder обращаемся к контексту и на нем вызываем метод Auth. Из сессии получаемп obj, которйы был положен в данную сессию после аутен.пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        System.out.println("user ID: "+personDetails.getPerson().getId());
        System.out.println("user login: "+personDetails.getPerson().getLogin());
        System.out.println("user password: "+personDetails.getPerson().getPassword());
        return "index";
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
        return "redirect:/index";

    }

}

