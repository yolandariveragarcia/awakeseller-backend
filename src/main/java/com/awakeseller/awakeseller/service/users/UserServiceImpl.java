package com.awakeseller.awakeseller.service.users;

import org.springframework.stereotype.Service;

import com.awakeseller.awakeseller.controller.users.UserDto;
import com.awakeseller.awakeseller.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  @Override
  public UserDto findByUserName(final String username) {
    return userRepository.findByUsername(username)
        .map(user -> new UserDto(user.getId(), user.getUsername()))
        .orElseThrow();
  }

}