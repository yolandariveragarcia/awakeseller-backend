package com.awakeseller.awakeseller.client.etsy.transactions.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Transaction {

    private Long transactionId;

    private String title;

    private String description;

    private Price price;
}