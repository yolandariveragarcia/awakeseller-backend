package com.awakeseller.awakeseller.service.users;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.awakeseller.awakeseller.client.etsy.users.EtsyUsers;
import com.awakeseller.awakeseller.client.etsy.users.model.EtsyUser;
import com.awakeseller.awakeseller.config.SecurityUser;
import com.awakeseller.awakeseller.model.User;
import com.awakeseller.awakeseller.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailService {

  private UserRepository userRepository;

  private EtsyUsers etsyUsers;

  @Override
  public SecurityUser loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .map(user -> new SecurityUser(user.getUsername()))
        .orElseThrow();
  }

  @Override
  public Optional<SecurityUser> loadUserByEtsyId(Long etsyId) {
    return userRepository.findByEtsyId(etsyId)
        .map(user -> new SecurityUser(user.getUsername()));
  }

  @Override
  public SecurityUser createEtsyUser(Map<String, String> headers, Long etsyId) {

    EtsyUser etsyUser = etsyUsers.getUser(headers, etsyId);

    User user = new User();

    user.setEtsyId(etsyUser.getUserId());
    user.setUsername(etsyUser.getPrimaryEmail());
    user.setFirstName(etsyUser.getFirstName());
    user.setLastName(etsyUser.getLastName());

    userRepository.save(user);

    return new SecurityUser(user.getUsername());
  }
}
