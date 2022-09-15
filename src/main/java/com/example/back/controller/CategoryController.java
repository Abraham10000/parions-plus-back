package com.example.back.controller;

import com.example.back.model.Category;
import com.example.back.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PostMapping("/category")
    public Category AddCategory(@RequestBody Category newCategory){
        return categoryService.AddCategory(newCategory);
    }

    @DeleteMapping("/category{id}")
    public String deleteCategory(@PathVariable Integer id){
        return categoryService.DeleteCategory(id);
    }
}
