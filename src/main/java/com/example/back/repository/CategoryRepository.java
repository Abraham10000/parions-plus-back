package com.example.back.repository;

import com.example.back.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category , Integer> {

    @Query(value = "select * from category order by category_name asc",nativeQuery = true)
    List<Category> findAll();
}
