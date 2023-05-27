package com.awakeseller.awakeseller.client.etsy.listings.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Listing {

  private long listingId;

  private long userId;

  private long shopId;

  private String title;

  private String description;

}
