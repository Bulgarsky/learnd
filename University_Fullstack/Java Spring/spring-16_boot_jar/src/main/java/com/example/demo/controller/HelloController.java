package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
    @Value("${hello}")
    private String helloMsg;

    @GetMapping("/hello")
    private void Hello(){
        System.out.println(helloMsg);
    }
}

//cd..
//ls - просмотр папки нахождения
//pwd - просмотр пути

//JAR для загрузки на сервер?
// ./mvnw package
//cd target
//java -jar demo-0.0.1-SNAPSHOT.jar
//