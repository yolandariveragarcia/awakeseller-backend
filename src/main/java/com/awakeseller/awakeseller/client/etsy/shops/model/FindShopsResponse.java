package com.awakeseller.awakeseller.client.etsy.shops.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class FindShopsResponse {

  private int count;

  private List<Shop> results;
}
