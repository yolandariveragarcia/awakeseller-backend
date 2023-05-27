package com.awakeseller.awakeseller.controller.products;

import lombok.Data;

@Data
public class ShopDto {

  private Long shopId;

  private Long userId;

  private String shopName;

  private String title;

  private String imageUrl;

  private Long numFavorers;

  private Long transactionSoldCount;

  private Long reviewCount;

  private Long reviewAverage;

}
