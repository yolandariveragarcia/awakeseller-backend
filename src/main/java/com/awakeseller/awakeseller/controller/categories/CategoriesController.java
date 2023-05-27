package com.awakeseller.awakeseller.controller.categories;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakeseller.awakeseller.service.categories.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoriesController {

  private CategoryService categoryService;

  @GetMapping
  public List<CategoryDto> getCategories() {
    return categoryService.getCategories();
  }
}
