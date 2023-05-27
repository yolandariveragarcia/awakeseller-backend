package com.awakeseller.awakeseller.service.users;

import java.util.Map;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.awakeseller.awakeseller.config.SecurityUser;

public interface CustomUserDetailService extends UserDetailsService {

  Optional<SecurityUser> loadUserByEtsyId(Long etsyId);

  SecurityUser createEtsyUser(Map<String, String> headers, Long etsyId);
}
