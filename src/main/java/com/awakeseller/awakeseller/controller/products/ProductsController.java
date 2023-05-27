package com.awakeseller.awakeseller.controller.products;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.awakeseller.awakeseller.service.products.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductsController {

  private ProductService productService;

  @GetMapping
  public List<ProductDto> findProducts(@RequestParam("keywords") String keywords) {
    return productService.findProductsByKeywords(keywords);
  }
}
