package com.awakeseller.awakeseller.controller.products;

import lombok.Data;

@Data
public class ProductDto {

  private Long id;

  private Long userId;

  private Long shopId;

  private String title;

  private String description;

  private Long quantity;

}
