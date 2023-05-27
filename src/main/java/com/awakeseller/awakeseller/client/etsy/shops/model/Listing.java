package com.awakeseller.awakeseller.client.etsy.shops.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Listing {

  private Long listingId;

  private Long userId;

  private Long shopId;

  private String title;

  private String description;

  private Long quantity;
}
