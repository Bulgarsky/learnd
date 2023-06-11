package com.example.market.services;

import com.example.market.models.Category;
import com.example.market.models.Product;
import com.example.market.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public CategoryService(CategoryRepository categoryRepository, ProductService productService) {
        this.categoryRepository = categoryRepository;
        this.productService = productService;
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

    public Category getCategory(int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }

    public void updateCategory(int categoryId, Category updatedCategory){
        Category saveCategory = new Category();
        saveCategory.setId(categoryId);
        saveCategory.setTitle(updatedCategory.getTitle());
        saveCategory.setDescription(updatedCategory.getDescription());
        categoryRepository.save(saveCategory);
    }

    @Transactional
    public void deleteCategory (int id){
        categoryRepository.deleteById(id);
    }

    public void changeCategoryStatus (int id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category tempCategory = new Category();
        tempCategory.setId(optionalCategory.get().getId());
        tempCategory.setTitle(optionalCategory.get().getTitle());
        tempCategory.setDescription(optionalCategory.get().getDescription());
        tempCategory.setEnabled(!tempCategory.isEnabled());

        categoryRepository.save(tempCategory);
    }

    public List<Product> getCategoryProducts(int id){
        return productService.getProductByCategory(id);
    }

}
