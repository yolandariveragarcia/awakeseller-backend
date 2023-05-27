package com.awakeseller.awakeseller.client.etsy.shops.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Shop {

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
