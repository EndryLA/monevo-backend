package com.monevo.monevo.services;

import com.monevo.monevo.models.Category;
import com.monevo.monevo.models.User;
import com.monevo.monevo.repositories.CategoryRepository;
import com.monevo.monevo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public List<Category> getCategoriesByUserId(Integer userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return categoryRepository.findByUser(user);
    }

    public Category getCategoryById(Integer categoryId) {

        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, Integer categoryId) {
        Category categoryToUpdate = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        categoryToUpdate.setType(category.getType());
        categoryToUpdate.setName(category.getName());

        return categoryRepository.save(categoryToUpdate);
    }

    public void deleteCategory(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
