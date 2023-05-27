package com.awakeseller.awakeseller.service.categories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.awakeseller.awakeseller.client.etsy.taxonomy.SellerTaxonomy;
import com.awakeseller.awakeseller.client.etsy.taxonomy.model.TaxonomyNode;
import com.awakeseller.awakeseller.controller.categories.CategoryDto;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private SellerTaxonomy sellerTaxonomy;

  @Override
  public List<CategoryDto> getCategories() {

    var response = sellerTaxonomy.getSellerTaxonomyNodes();

    List<CategoryDto> categories = new ArrayList<>();
    for (TaxonomyNode taxonomyNode : response.getResults()) {

      List<CategoryDto> children = copyChildren(taxonomyNode.getChildren());

      CategoryDto categoryDto = new CategoryDto();
      categoryDto.setId(taxonomyNode.getId());
      categoryDto.setName(taxonomyNode.getName());
      categoryDto.setChildren(children);

      categories.add(categoryDto);
    }

    return categories;
  }

  private List<CategoryDto> copyChildren(List<TaxonomyNode> children) {

    List<CategoryDto> childCategories = new ArrayList<>();

    for (TaxonomyNode child : children) {

      List<CategoryDto> children2 = copyChildren(child.getChildren());

      CategoryDto categoryDto = new CategoryDto();
      categoryDto.setId(child.getId());
      categoryDto.setName(child.getName());
      categoryDto.setChildren(children2);

      childCategories.add(categoryDto);
    }

    return childCategories;
  }

}
