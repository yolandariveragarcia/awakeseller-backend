package com.awakeseller.awakeseller.service.transactions;

import com.awakeseller.awakeseller.controller.transactions.TransactionDto;

import java.util.List;

public interface TransactionService {

   List<TransactionDto> findLatestTransactionByUserId(Long userId);
}
