package com.awakeseller.awakeseller.client.etsy.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GetTransactionsByShopResponse {

  private int count;

  private List<Transaction> results;
}
