package com.example.users.controllers;

import com.example.users.dao.DaoUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class User {
    private final DaoUser daoUser;

    public User(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    //get userList and return view
    @GetMapping("/user")
    public String index(Model model) {
        model.addAttribute("user", daoUser.getUserList());
        return "user";
    }

    //get add_user form view
    @GetMapping("/user/add")
    public String addUser(Model model){
        model.addAttribute("user", new com.example.users.models.User());
        return "add_user";
    }
    //submit form and safe user
    @PostMapping("user/add")
    public String newUser(@ModelAttribute("user") com.example.users.models.User user) {
        daoUser.addUser(user);
        return "redirect:/user";
    }
    //get id and return user.{id}-info view
    @GetMapping("/user/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", daoUser.getUserId(id));
        return "user_info";
    }

    //get obj for redact and return form view w/ fields
    @GetMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("editUser", daoUser.getUserId(id));
        return "user_edit";
    }
    //update fields and safe obj
    @PostMapping("/user/edit/{id}")
    public String updateEditUser(
            @ModelAttribute("editUser")com.example.users.models.User user,
            @PathVariable("id") int id) {
        daoUser.updateUser(id, user);
        return "redirect:/user";
    }

    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        daoUser.removeUser(id);
        return "redirect:/user";
    }

}
