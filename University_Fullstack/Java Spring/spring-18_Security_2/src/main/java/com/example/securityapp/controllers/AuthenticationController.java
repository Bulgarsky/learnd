package com.example.securityapp.controllers;

import com.example.securityapp.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AuthenticationController {

    @GetMapping("/auth")
    public String login(){
        return "auth";
    }

    /*
    @GetMapping("/reg")
    public String registration(Model model){
        model.addAttribute("person", new Person());
        return "reg";
    }
     */
    @GetMapping("/reg")
    public String registration(@ModelAttribute("person") Person person){
        return "reg";
    }

}
