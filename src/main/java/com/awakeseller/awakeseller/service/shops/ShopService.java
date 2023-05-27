package com.awakeseller.awakeseller.service.shops;

import java.util.List;

import com.awakeseller.awakeseller.controller.products.ProductDto;
import com.awakeseller.awakeseller.controller.shops.ShopDto;

public interface ShopService {

  List<ShopDto> findShopsByName(String name);

  List<ProductDto> findProductsByShopId(Long id);

}
