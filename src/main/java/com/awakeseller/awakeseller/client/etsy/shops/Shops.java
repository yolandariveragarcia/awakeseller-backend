package com.awakeseller.awakeseller.client.etsy.shops;

import com.awakeseller.awakeseller.client.etsy.shops.model.Shop;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.awakeseller.awakeseller.client.etsy.auth.OAuthFeignConfig;
import com.awakeseller.awakeseller.client.etsy.shops.model.FindShopsResponse;
import com.awakeseller.awakeseller.client.etsy.shops.model.FindAllActiveListingsByShopResponse;

@FeignClient(name = "shops", url = "https://openapi.etsy.com/v3/application/",
    configuration = OAuthFeignConfig.class)
public interface Shops {

  /**
   * https://developers.etsy.com/documentation/reference/#operation/findShops
   */
  @GetMapping(path = "shops")
  FindShopsResponse findShops(@RequestParam("shop_name") String shopName);

  /**
   * https://developers.etsy.com/documentation/reference/#operation/findAllActiveListingsByShop
   */
  @GetMapping(path = "shops/{shop_id}/listings/active")
  FindAllActiveListingsByShopResponse findAllActiveListingsByShop(@PathVariable("shop_id") Long shopId);

  /**
   * https://developers.etsy.com/documentation/reference#operation/getShopByOwnerUserId
   */
  @GetMapping(path = "users/{user_id}/shops")
  Shop getShopByOwnerUserId(@PathVariable("user_id") Long userId);
}
