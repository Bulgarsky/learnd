package com.example.market.controllers;

import com.example.market.models.Category;
import com.example.market.models.Product;
import com.example.market.repositories.CategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AdminController {
    @Value("${upload.path}")
    private String uploadPath;

    private final CategoryRepository categoryRepository;

    public AdminController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/admin/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("category", categoryRepository.findAll());
        return "product/addProduct";
    }

    @PostMapping("/admin/product/add")
    public String addProduct(
            @ModelAttribute("product") @Valid Product product,
            BindingResult bindingResult,
            @RequestParam("file_1")MultipartFile file_1,
            @RequestParam("file_2")MultipartFile file_2,
            @RequestParam("file_3")MultipartFile file_3,
            @RequestParam("file_4")MultipartFile file_4,
            @RequestParam("file_5")MultipartFile file_5,
            @RequestParam("category") int category,
            Model model
            ){
        Category category_db = categoryRepository.findById(category).orElseThrow();
        System.out.println(category_db.getTitle());
        if(bindingResult.hasErrors()){
            model.addAttribute("category", categoryRepository.findAll());
            return "product/addProduct";
        }
        return null;
    }



}
