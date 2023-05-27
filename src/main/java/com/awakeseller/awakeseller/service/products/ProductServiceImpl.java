package com.awakeseller.awakeseller.service.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.awakeseller.awakeseller.client.etsy.listings.Listings;
import com.awakeseller.awakeseller.client.etsy.shops.model.Listing;
import com.awakeseller.awakeseller.controller.products.ProductDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

  private Listings listings;

  @Override
  public List<ProductDto> findProductsByKeywords(String keywords) {

    var response = listings.findAllListingsActive(keywords);

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
