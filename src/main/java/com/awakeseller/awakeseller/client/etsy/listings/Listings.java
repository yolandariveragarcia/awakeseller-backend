package com.awakeseller.awakeseller.client.etsy.listings;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.awakeseller.awakeseller.client.etsy.auth.OAuthFeignConfig;
import com.awakeseller.awakeseller.client.etsy.listings.model.FindAllListingsActiveResponse;

@FeignClient(name = "listings", url = "https://openapi.etsy.com/v3/application/listings/",
    configuration = OAuthFeignConfig.class)
public interface Listings {

  /**
   * https://developers.etsy.com/documentation/reference/#operation/findAllListingsActive
   */
  @GetMapping("active")
  FindAllListingsActiveResponse findAllListingsActive(@RequestParam("keywords") String keywords);

}
