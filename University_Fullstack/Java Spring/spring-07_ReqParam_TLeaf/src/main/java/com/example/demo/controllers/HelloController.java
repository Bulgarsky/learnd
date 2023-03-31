package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller //extend @Component
@RequestMapping("spring/")
public class HelloController {

    /* //HttpServletRequest избыточен при получении некоторых данных
    @GetMapping("/hello") //получение names from getParameter
    public String getHello(HttpServletRequest request) {
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");

        System.out.println("\n[request.getParameter] \nlastName: "+lastName+"\nfirstName: "+firstName+"\nmiddleName: "+middleName);
        return "hello";
    }
    */
    /*
    @GetMapping("/hello") //получение names from getParameter.
    public String getHelloUser( //метод ожидает получение параметров. Если их нет - ошибка
                            //default(required=true) - все  аргументы обязательны (
                            //@RequestParam("lastName") String lastName, - default
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "middleName", required = false) String middleName ) {
        System.out.println("\n[request.getParameter] " +
                "\nlastName: "+lastName+"" +
                "\nfirstName: "+firstName+"" +
                "\nmiddleName: "+middleName);

        return "hello";
    }
    */

    //http://localhost:8085/spring/hello?lastName=Ivanov&firstName=Sergey&middleName=Antonovich
    @GetMapping("/hello") //получение names from getParameter.
    public String getHelloUser(
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "middleName", required = false) String middleName,
            Model model) {
        model.addAttribute("lastName", lastName);
        model.addAttribute("firstName", firstName);
        model.addAttribute("middleName", middleName);

        System.out.println("\n[User data]\nlastName: "+lastName+"\nfirstName: "+firstName+"\nmiddleName: "+middleName);

        return "hello";
    }


}