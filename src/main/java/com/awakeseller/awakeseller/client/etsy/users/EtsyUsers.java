package com.awakeseller.awakeseller.client.etsy.users;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.awakeseller.awakeseller.client.etsy.users.model.EtsyUser;

@FeignClient(name = "users", url = "https://openapi.etsy.com/v3/application/users/")
public interface EtsyUsers {

  /**
   * https://developers.etsy.com/documentation/reference/#operation/getUser
   */
  @GetMapping(path = "{user_id}")
  EtsyUser getUser(@RequestHeader Map<String, String> headers, @PathVariable("user_id") Long userId);

}
