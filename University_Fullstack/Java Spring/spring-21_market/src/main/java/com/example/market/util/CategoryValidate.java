//package com.example.market.util;
//
//import com.example.market.models.Category;
//import com.example.market.services.CategoryService;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//
//public class CategoryValidate implements Validator {
//    private final CategoryService categoryService;
//
//    public CategoryValidate(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz){
//        return Category.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Category category = (Category) target;
////        if (categoryService.getCategory(category.getId()).getId() == 0) {
////            errors.rejectValue("id", "", "Данная категория ReadOnly");
////        }
//    }
//}
