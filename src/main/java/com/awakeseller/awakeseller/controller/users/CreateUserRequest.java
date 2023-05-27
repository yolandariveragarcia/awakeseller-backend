package com.awakeseller.awakeseller.controller.users;

import lombok.Data;

@Data
public class CreateUserRequest {

  private String username;

  private String password;
}
