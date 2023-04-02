package com.example.users.controllers;

import com.example.users.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/user")
public class User {
    private final UserService userService;

    @Autowired
    public User(UserService userService) {
        this.userService = userService;
    }


    //get userList and return view
    @GetMapping("/user")
    public String index(Model model) {
        model.addAttribute("user", userService.getAllUser());
        return "user";
    }

    //get add_user form view
    @GetMapping("/user/add")
    public String addUser(Model model){
        model.addAttribute("user", new com.example.users.models.User());
        return "add_user";
    }
    //submit form, validate, and safe user
    @PostMapping("user/add")
    public String newUser(
            @ModelAttribute("user")
            @Valid com.example.users.models.User newUser,
            BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "add_user";
        }
        //daoUser.addUser(newUser);
        userService.addUser(newUser);
        return "redirect:/user";
    }
    //get id and return user.{id}-info view
    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserId(id));
        return "user_info";
    }

    //get obj for redact and return form view w/ fields
    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("editUser", userService.getUserId(id));
        return "user_edit";
    }
    //update fields and safe obj
    @PostMapping("/user/edit/{id}")
    public String updateEditUser(
            @ModelAttribute("editUser")@Valid com.example.users.models.User user,
            BindingResult bindingResult,
            @PathVariable("id") int id) {
        if(bindingResult.hasErrors()){
            return "user_edit";
        }
        //daoUser.updateUser(id, user);
        userService.editUser(id, user);
        return "redirect:/user";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        //daoUser.removeUser(id);
        userService.deleteUser(id);
        return "redirect:/user";
    }

    //методы сортировки
    @GetMapping("/ssf")
    public String sortAndSearch(){
        return "/ssf";
    }
    @PostMapping("/ssf")
    public String sortAndSearch(
            @RequestParam("filterOptions") String filterOptions,
            @RequestParam("lookingRequest") String lookingRequest,
            Model model){
        if(filterOptions.equals("email")) {
            model.addAttribute("user", userService.getUserEmail(lookingRequest));
        }else if(filterOptions.equals("phoneNo")) {
            model.addAttribute("user", userService.getUserPhoneNo(lookingRequest));
        }else if(filterOptions.equals("lastName")) {
            model.addAttribute("user", userService.getUserLastNameOrderByAge(lookingRequest));
        }else if(filterOptions.equals("lastNameStart")) {
            model.addAttribute("user", userService.getUserLastNameStartingWith(lookingRequest));
        }else if(filterOptions.equals("lastNameDesc")) {
            model.addAttribute("user", userService.findByLastNameOrderByAgeDesc(lookingRequest));
        }
        return "/ssf";
    }

}
