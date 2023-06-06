package com.example.market.services;

import com.example.market.models.Category;
import com.example.market.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void saveCategory(String title, String description){
        Category newCategory = new Category();
        newCategory.setTitle(title);
        newCategory.setDescription(description);
        categoryRepository.save(newCategory);
    }
}
