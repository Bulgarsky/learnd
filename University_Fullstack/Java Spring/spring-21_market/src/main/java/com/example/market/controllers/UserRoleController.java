package com.example.market.controllers;

import com.example.market.enumm.Role;
import com.example.market.models.Person;
import com.example.market.services.PersonService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

//Вывод пользователей по ролям?
@Controller
public class UserRoleController {

    private final PersonService personService;
    private final AuthenticationController authController;

    public UserRoleController(PersonService personService, AuthenticationController authController) {
        this.personService = personService;
        this.authController = authController;
    }

    //вывод пользователей по ролям
    //dynamic ModelAndView(page) ?
    // https://stackoverflow.com/questions/17607229/spring-mvc-dynamic-view-handling-non-existing-views

    //Нужна реализация pagination для больших массивов данных
    @GetMapping("/terminal/users/{role}")
    public String getUsersByRole(
            Model model,
            @PathVariable("role") String getRole
            //@PathVariable("role") Role role
            ){
        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        String currentRole = "ROLE_" + getRole.toUpperCase();

        for (Role each: Role.values()) {

            if (each.toString().contentEquals(currentRole)) {

                List<Person> personList = personService.getUsersByRole(currentRole);

                model.addAttribute("currentRole", each);
                model.addAttribute("personList", personList);
                model.addAttribute("personCount", personList.size());

                //нужен динамический возврат представлений
                switch (each) {
                    case ROLE_USER -> {
                        return "/admin/role/customers";
                    }
                    case ROLE_ADMIN -> {
                        return "/admin/role/admins";
                    }
                    case ROLE_SELLER -> {
                        return "/admin/role/sellers";
                    }
                    case ROLE_MODERATOR -> {
                        return "/admin/role/moderators";
                    }
                }
            }
        }
        return "/404";
    }



    //                switch (each) {
//                    case ROLE_USER -> {
//                        List<Person> customers = personService.getCustomers();
//                        model.addAttribute("customers", customers);
//                        model.addAttribute("customerCount",customers.size());
//                        return "/admin/role/customers";
//                    }
//                    case ROLE_ADMIN -> {
//                        List<Person> admins = personService.getAdmins();
//                        model.addAttribute("admins", admins);
//                        model.addAttribute("adminCount",admins.size());
//                        return "/admin/role/admins";
//                    }
//                    case ROLE_SELLER -> {
//                        return "/admin/role/sellers";
//                    }
//                    case ROLE_MODERATOR -> {
//                        return "/admin/role/moderators";
//                    }
}
