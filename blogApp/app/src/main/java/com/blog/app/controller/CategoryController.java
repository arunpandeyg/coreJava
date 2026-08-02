package com.blog.app.controller;

import com.blog.app.dto.CategoryDto;
import com.blog.app.paloads.ApiResponse;
import com.blog.app.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    //update
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory( @PathVariable Integer categoryId){
         this.categoryService.deleteCategory(categoryId);
         return new ResponseEntity<>(new ApiResponse("category is deleted successfully", true), HttpStatus.OK);
    }
    //get one
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory( @PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategory(categoryId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
    //get all
    @GetMapping("/")
    public ResponseEntity <List<CategoryDto>>getCategories(){
        List< CategoryDto> categories  = this.categoryService.getCategories();
        return  ResponseEntity.ok(categories);
    }

}
