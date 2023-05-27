package com.awakeseller.awakeseller.controller.transactions;

import com.awakeseller.awakeseller.service.transactions.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@AllArgsConstructor
public class TransactionsController {

    private static final String TOKEN_PREFIX = "Bearer ";

    private TransactionService transactionService;

    @GetMapping
    public List<TransactionDto> getTransactions(@RequestHeader("Authorization") String authorizationHeader) {
        var authToken = authorizationHeader.replace(TOKEN_PREFIX, "");
        var etsyId = authToken.split("\\.")[0];
        Long userId = Long.valueOf(etsyId);
        return transactionService.findLatestTransactionByUserId(userId);
    }
}

