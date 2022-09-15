package com.example.back.service;


import com.example.back.model.Category;
import com.example.back.model.Competition;
import com.example.back.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    public CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category AddCategory(Category category){
        return categoryRepository.save(category);
    }

    public String DeleteCategory(Integer Id){
        categoryRepository.deleteById(Id);
        return "Delete Successfully";
    }

}
