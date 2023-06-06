package com.example.market.controllers;

import com.example.market.models.Category;
import com.example.market.models.Person;
import com.example.market.security.PersonDetails;
import com.example.market.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/category")
    public String getCategory(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        Person currentPerson = personDetails.getPerson();
        Person currentPerson= getCurrentAuthPerson();
        model.addAttribute("userAuth", currentPerson);

        List<Category> categoryList = categoryService.getCategoryList();
        for (Category element: categoryList) {
            if (element.getDescription() == null) {
                element.setDescription("Описание раздела не заполнено");
            }
        }

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("categoryCount", categoryList.size());


        switch (currentPerson.getRole()){
            case "ROLE_USER", "ROLE_SELLER" -> {
                return "/404";
            }
            case "ROLE_ADMIN" -> {
                return "admin/category";
            }
        }

        return "/404";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model){
        model.addAttribute("newCategory", new Category());
        return "/admin/category/addCategory";
    }

    @PostMapping("/category/add")
    public String addCategory(
            @ModelAttribute("newCategory") @Valid Category category,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ){
        //Добавить проверку и положить ошибку в еррор

        categoryService.saveCategory(title, description);
        return "redirect:/category";
    }

    public Person getCurrentAuthPerson(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
        return personDetails.getPerson();
    }
}



