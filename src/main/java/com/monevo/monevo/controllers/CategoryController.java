package com.monevo.monevo.controllers;

import com.monevo.monevo.models.Category;
import com.monevo.monevo.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
