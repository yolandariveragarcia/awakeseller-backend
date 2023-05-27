package com.awakeseller.awakeseller.client.etsy.users.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class EtsyUser {

  private Long userId;

  private String primaryEmail;

  private String firstName;

  private String lastName;

}
