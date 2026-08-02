package com.blog.app.services;

import com.blog.app.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto categoryDto);
    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
    //delete
    void deleteCategory(Integer categoryId);
    //get one
    CategoryDto getCategory(Integer categoryId);
    //get all
    List<CategoryDto> getCategories();

}
