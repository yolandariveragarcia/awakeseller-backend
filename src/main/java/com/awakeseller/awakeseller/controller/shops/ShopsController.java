package com.awakeseller.awakeseller.controller.shops;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awakeseller.awakeseller.controller.products.ProductDto;
import com.awakeseller.awakeseller.service.shops.ShopService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/shops")
@AllArgsConstructor
public class ShopsController {

  private ShopService shopService;

  @GetMapping
  public List<ShopDto> findShops(@RequestParam String name) {
    return shopService.findShopsByName(name);
  }

  @GetMapping(path = "{shopId}/products")
  public List<ProductDto> findProducts(@PathVariable("shopId") Long shopId) {
    return shopService.findProductsByShopId(shopId);
  }
}
