package com.blog.app.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Integer categoryId;
    @NotEmpty
    @Size(min = 3, max = 20, message = "Category Title should not be less then 3 and more then 20 characters !!")
    private String categoryTitle;
    @NotEmpty
    @Size(min = 10, message = "Category Description must be more then 10 characters !!")
    private String categoryDescription;
}
