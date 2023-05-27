package com.awakeseller.awakeseller.config;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AccessToken.TokenType;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.awakeseller.awakeseller.service.users.CustomUserDetailService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EtsyAuthenticationFilter extends OncePerRequestFilter {

  private static final String TOKEN_PREFIX = "Bearer ";
  private static final String HEADER_STRING = "Authorization";

  @Autowired
  private CustomUserDetailService userDetailService;

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
      FilterChain chain) throws IOException, ServletException {

    final String authorizationHeader = req.getHeader(HEADER_STRING);
    if (authorizationHeader != null && authorizationHeader.startsWith(TOKEN_PREFIX)) {
      // El user id es el numero que aparece antes del punto en el token de Etsy
      // https://api.etsy.com/v3/public/oauth/token
      var authToken = authorizationHeader.replace(TOKEN_PREFIX, "");
      var etsyId = authToken.split("\\.")[0];

      if (etsyId != null && SecurityContextHolder.getContext().getAuthentication() == null) {

        // Buscamos el usuario en la base de datos
        var databaseUser = userDetailService.loadUserByEtsyId(Long.valueOf(etsyId));

        UserDetails userDetails;
        if (databaseUser.isPresent()) {
          // Si esta lo usamos
          userDetails = databaseUser.get();
        } else {
          // Si no esta, lo guardamos y usamos el recien creado
          Map<String, String> headers = Map.of(
              "Authorization", authorizationHeader,
              "x-api-key", clientRegistrationRepository.findByRegistrationId("etsy").getClientId());
          userDetails = userDetailService.createEtsyUser(headers, Long.valueOf(etsyId));
        }

        var authentication = new EtsyAuthenticationPrincipal(userDetails,
            new OAuth2AccessToken(TokenType.BEARER, authToken, null, null));
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        authentication.setAuthenticated(true);
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    chain.doFilter(req, res);
  }
}