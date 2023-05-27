package com.awakeseller.awakeseller.client.etsy.taxonomy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.awakeseller.awakeseller.client.etsy.auth.OAuthFeignConfig;
import com.awakeseller.awakeseller.client.etsy.taxonomy.model.GetSellerTaxonomyNodesResponse;

@FeignClient(name = "seller-taxonomy", url = "https://openapi.etsy.com/v3/application/seller-taxonomy/",
    configuration = OAuthFeignConfig.class)
public interface SellerTaxonomy {

  /**
   * https://developers.etsy.com/documentation/reference/#operation/getSellerTaxonomyNodes
   */
  @GetMapping("nodes")
  GetSellerTaxonomyNodesResponse getSellerTaxonomyNodes();
}
