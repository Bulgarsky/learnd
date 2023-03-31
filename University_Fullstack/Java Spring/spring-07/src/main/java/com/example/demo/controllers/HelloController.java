package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //extend @Component
@RequestMapping("home/")
public class HelloController {
    @GetMapping("/hello") //url
    public String getHello() {
        return "hello"; //return hello view from templates
    }

    @GetMapping("/about")
    public String getMessage(){
        return "about";
    }
}