package com.awakeseller.awakeseller.client.etsy.listings.model;

import java.util.List;

import com.awakeseller.awakeseller.client.etsy.shops.model.Listing;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FindAllListingsActiveResponse {

  private int count;

  private List<Listing> results;
}
