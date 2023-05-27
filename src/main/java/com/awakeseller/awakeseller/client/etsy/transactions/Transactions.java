package com.awakeseller.awakeseller.client.etsy.transactions;

import com.awakeseller.awakeseller.client.etsy.transactions.model.GetTransactionsByShopResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.awakeseller.awakeseller.client.etsy.auth.OAuthFeignConfig;
import com.awakeseller.awakeseller.client.etsy.shops.model.FindShopsResponse;
import com.awakeseller.awakeseller.client.etsy.shops.model.FindAllActiveListingsByShopResponse;

@FeignClient(name = "transactions", url = "https://openapi.etsy.com/v3/application/shops/",
        configuration = OAuthFeignConfig.class)
public interface Transactions {

    /**
     * https://developers.etsy.com/documentation/reference/#operation/getShopReceiptTransactionsByShop
     */
    @GetMapping(path = "{shop_id}/transactions")
    GetTransactionsByShopResponse getShopReceiptTransactionsByShop(@RequestParam("shop_id") Long shopId);
}

