package com.awakeseller.awakeseller.service.transactions;

import com.awakeseller.awakeseller.client.etsy.shops.Shops;
import com.awakeseller.awakeseller.client.etsy.shops.model.Shop;
import com.awakeseller.awakeseller.client.etsy.transactions.Transactions;
import com.awakeseller.awakeseller.client.etsy.transactions.model.GetTransactionsByShopResponse;
import com.awakeseller.awakeseller.client.etsy.transactions.model.Price;
import com.awakeseller.awakeseller.client.etsy.transactions.model.Transaction;
import com.awakeseller.awakeseller.controller.products.ProductDto;
import com.awakeseller.awakeseller.controller.transactions.TransactionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private Shops shops;

    private Transactions transactions;


    @Override
    public List<TransactionDto> findLatestTransactionByUserId(Long userId) {

        Shop shop = shops.getShopByOwnerUserId(userId);

        // Como la tienda de pruebas no tiene transacciones voy a utilizar una de ejemplo. Sino sería: shop.getShopId()

        Long shopIdPrueba=41554347L;
        GetTransactionsByShopResponse transactionsResponse = transactions.getShopReceiptTransactionsByShop(shopIdPrueba);

        List<TransactionDto> transactions = new ArrayList<>();

        for(Transaction transaction : transactionsResponse.getResults()){
            TransactionDto transactionDto = new TransactionDto();

            transactionDto.setTransactionId(transaction.getTransactionId());
            transactionDto.setTitle(transaction.getTitle());
            transactionDto.setDescription(transaction.getDescription());

            Price price = transaction.getPrice();

            BigDecimal finalPrice = new BigDecimal(price.getAmount())
                    .divide(new BigDecimal(price.getDivisor()), 2, RoundingMode.HALF_UP);

            transactionDto.setPrice(finalPrice);
            transactionDto.setCurrency(price.getCurrencyCode());


            transactions.add(transactionDto);
        }

        return transactions;
    }
}
