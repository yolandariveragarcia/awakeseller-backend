package com.awakeseller.awakeseller.controller.users;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awakeseller.awakeseller.service.users.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @GetMapping("current")
  public UserDto getCurrentUser(final Principal principal) {
    return userService.findByUserName(principal.getName());
  }
}
