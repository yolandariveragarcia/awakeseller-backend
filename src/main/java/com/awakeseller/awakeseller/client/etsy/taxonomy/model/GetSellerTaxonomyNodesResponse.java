package com.awakeseller.awakeseller.client.etsy.taxonomy.model;

import java.util.List;

import lombok.Data;

@Data
public class GetSellerTaxonomyNodesResponse {

    private Integer count;

    private List<TaxonomyNode> results;

}
