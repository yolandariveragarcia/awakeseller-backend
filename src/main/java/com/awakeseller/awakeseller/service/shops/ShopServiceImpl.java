package com.awakeseller.awakeseller.service.shops;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import com.awakeseller.awakeseller.client.etsy.shops.Shops;
import com.awakeseller.awakeseller.client.etsy.shops.model.Listing;
import com.awakeseller.awakeseller.client.etsy.shops.model.Shop;
import com.awakeseller.awakeseller.controller.products.ProductDto;
import com.awakeseller.awakeseller.controller.shops.ShopDto;

import lombok.RequiredArgsConstructor;

@Component
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

  private Shops shops;

  @Override
  public List<ShopDto> findShopsByName(String name) {

    var response = shops.findShops(name);

    List<ShopDto> shops = new ArrayList<>();

    for (Shop shop : response.getResults()) {
      ShopDto shopDto = new ShopDto();

      shopDto.setShopId(shop.getShopId());
      shopDto.setUserId(shop.getUserId());
      shopDto.setShopName(shop.getShopName());
      shopDto.setTitle(shop.getTitle());
      shopDto.setImageUrl(shop.getImageUrl());
      shopDto.setNumFavorers(shop.getNumFavorers());
      shopDto.setTransactionSoldCount(shop.getTransactionSoldCount());
      shopDto.setReviewCount(shop.getReviewCount());
      shopDto.setReviewAverage(shop.getReviewAverage());

      shops.add(shopDto);
    }

    return shops;
  }

  @Override
  public List<ProductDto> findProductsByShopId(Long shopId) {

    var response = shops.findAllActiveListingsByShop(shopId);

    List<ProductDto> products = new ArrayList<>();

    for (Listing listing : response.getResults()) {
      ProductDto productDto = new ProductDto();

      productDto.setId(listing.getListingId());
      productDto.setTitle(listing.getTitle());
      productDto.setDescription(listing.getDescription());
      productDto.setQuantity(listing.getQuantity());

      products.add(productDto);
    }

    return products;
  }

}
