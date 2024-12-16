package com.monevo.monevo.controllers;

import com.monevo.monevo.models.Category;
import com.monevo.monevo.models.User;
import com.monevo.monevo.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }

    @GetMapping("/{userid}")
    public List<Category> getCategoriesByUserId(@PathVariable("userid") Integer userId) {
        return categoryService.getCategoriesByUserId(userId);
    }

    @PostMapping("")
    public Category createCategory(@RequestBody  Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{categoryId}")
    public Category updateCategory(@RequestBody Category category, @PathVariable Integer categoryId) {
        return categoryService.updateCategory(category, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
