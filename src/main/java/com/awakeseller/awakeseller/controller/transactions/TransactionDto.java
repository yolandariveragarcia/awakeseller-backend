package com.awakeseller.awakeseller.controller.transactions;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionDto {

    private Long transactionId;

    private String title;

    private String description;

    private BigDecimal price;

    private String currency;
}
