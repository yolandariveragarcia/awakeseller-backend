package com.awakeseller.awakeseller.controller.shops;

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
