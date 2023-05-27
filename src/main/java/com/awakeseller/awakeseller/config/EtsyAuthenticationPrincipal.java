package com.awakeseller.awakeseller.config;

import java.util.Collections;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

public final class EtsyAuthenticationPrincipal extends AbstractAuthenticationToken {

  private static final long serialVersionUID = 5054049011474769174L;

  private UserDetails userDetails;

  private OAuth2AccessToken credentials;

  public EtsyAuthenticationPrincipal(UserDetails userDetails, OAuth2AccessToken credentials) {
    super(Collections.emptyList());
    this.userDetails = userDetails;
    this.credentials = credentials;
  }

  @Override
  public Object getCredentials() {
    return credentials;
  }

  @Override
  public Object getPrincipal() {
    return userDetails;
  }

}