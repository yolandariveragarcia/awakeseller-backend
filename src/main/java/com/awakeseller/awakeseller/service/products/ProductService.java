package com.awakeseller.awakeseller.service.products;

import java.util.List;

import com.awakeseller.awakeseller.controller.products.ProductDto;

public interface ProductService {

  List<ProductDto> findProductsByKeywords(String keywords);

}
