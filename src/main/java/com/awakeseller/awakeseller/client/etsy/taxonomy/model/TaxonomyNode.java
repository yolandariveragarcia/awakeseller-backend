package com.awakeseller.awakeseller.client.etsy.taxonomy.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TaxonomyNode {

  private Long id;

  private Integer level;

  private String name;

  private Long parentId;

  private List<TaxonomyNode> children;

  private List<Integer> fullPathTaxonomyIds;

}
