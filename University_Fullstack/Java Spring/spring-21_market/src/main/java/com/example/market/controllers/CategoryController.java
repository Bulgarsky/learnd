package com.example.market.controllers;

import com.example.market.models.Category;
import com.example.market.models.Person;
import com.example.market.services.CategoryService;
import com.example.market.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;
    private final AuthenticationController authController;

    public CategoryController(CategoryService categoryService, ProductService productService, AuthenticationController authController) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.authController = authController;
    }


    @GetMapping("/category")
    public String getCategory(Model model) {
        Person currentPerson = authController.getCurrentAuthPerson();
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
    //АКТИВНЫЕ и неактивные КАТЕГОРИИ (Соединить после добавления JS в один контроллер)
    @GetMapping("/category/enabled")
    public String getActiveCategory(Model model){

        List<Category> categoryList = categoryService.getCategoryList();
        List<Category> activeCategory = new ArrayList<>();
        for (Category element: categoryList) {
            if (element.isEnabled()) {
                activeCategory.add(element);
            }
        }

        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        model.addAttribute("activeCategory", activeCategory);
        model.addAttribute("activeCategoryCount", activeCategory.size());
        return "admin/category/enabledCategory";
    }

    @GetMapping("/category/disabled")
    public String getDisabledCategory(Model model){

        List<Category> categoryList = categoryService.getCategoryList();
        List<Category> disabledCategory = new ArrayList<>();
        for (Category element: categoryList) {
            if (!element.isEnabled()) {
                disabledCategory.add(element);
            }
        }

        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        model.addAttribute("disabledCategory", disabledCategory);
        model.addAttribute("disabledCategoryCount", disabledCategory.size());
        return "admin/category/disabledCategory";
    }

    //добавить новую категорию
    @GetMapping("/category/add")
    public String addCategory(Model model){
        model.addAttribute("newCategory", new Category());
        return "/admin/category/addCategory";
    }

    //Изменение статуса категории (активные используется при добавлении товаров)
    @GetMapping("/category/isEnabled/{id}")
    public String changeCategoryStatus(
            @PathVariable("id")int id){
        categoryService.changeCategoryStatus(id);
        return "redirect:/category";
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

    //редактирование
    @GetMapping("/category/edit/{id}")
    public String editCategory(
            Model model,
            @PathVariable int id){
        if (id != 0) {
            model.addAttribute("editCategory", categoryService.getCategory(id));
            return "admin/category/editCategory";
        }else{
            return "redirect:/category";
        }
    }

    @PostMapping("/category/edit/{id}")
    public String editCategory(
            @ModelAttribute("editCategory") Category updatedCategory,
            @PathVariable("id") int id,
            Model model
    ){
        if (id != 0) {
            categoryService.updateCategory(id, updatedCategory);
        }
        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        return "redirect:/category";
    }

    @GetMapping("/category/delete/{id}")
    public String deleteCategory(
            @PathVariable("id")int id){
        if (id != 0) {

            if(!productService.getProductByCategory(id).isEmpty()) {
                //добавить ошибку в еррор (вывести на страницу)
            } else {
                categoryService.deleteCategory(id);
            }

        }
        return "redirect:/category";
    }


    //переход внутрь категории
    @GetMapping("/category/info/{id}")
    public String aboutCategory(
            @PathVariable("id")int id,
            Model model){
        Category category = categoryService.getCategory(id);

        if (category.getDescription() == null) {
            category.setDescription("Описание данного раздела еще не заполнено");
        }

        model.addAttribute("userAuth", authController.getCurrentAuthPerson());
        model.addAttribute("aboutCategory", category);
        model.addAttribute("categoryProducts", categoryService.getCategoryProducts(id));
        model.addAttribute("categoryProductsCount",categoryService.getCategoryProducts(id).size());
        return "admin/category/infoCategory";
    }


}



