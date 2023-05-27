package com.awakeseller.awakeseller.controller.categories;

import java.util.List;

import lombok.Data;

@Data
public class CategoryDto {

  private Long id;

  private String name;

  private List<CategoryDto> children;
}
