package com.awakeseller.awakeseller.client.etsy.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;

import feign.RequestInterceptor;

public class OAuthFeignConfig {

  public static final String CLIENT_REGISTRATION_ID = "etsy";

  private final OAuth2AuthorizedClientService oAuth2AuthorizedClientService;

  private final ClientRegistrationRepository clientRegistrationRepository;

  public OAuthFeignConfig(final OAuth2AuthorizedClientService oAuth2AuthorizedClientService,
      final ClientRegistrationRepository clientRegistrationRepository) {
    this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
    this.clientRegistrationRepository = clientRegistrationRepository;
  }

  @Bean
  public RequestInterceptor requestInterceptor(final OAuth2AuthorizedClientManager oauth2AuthorizedClientManager) {
    return requestTemplate -> {

      final var clientRegistration = clientRegistrationRepository.findByRegistrationId(CLIENT_REGISTRATION_ID);

      /**
       * final OAuth2AuthorizeRequest oAuth2AuthorizeRequest = OAuth2AuthorizeRequest
       * .withClientRegistrationId(clientRegistration.getRegistrationId())
       * .principal(SecurityContextHolder.getContext().getAuthentication()) .build();
       *
       * final OAuth2AuthorizedClient client =
       * oauth2AuthorizedClientManager.authorize(oAuth2AuthorizeRequest); if (client
       * == null) { throw new IllegalStateException("client credentials flow on " +
       * clientRegistration.getRegistrationId() + " failed, client is null"); }
       *
       * final var token = client.getAccessToken().getTokenValue();
       *
       *
       * requestTemplate.header("Authorization", "Bearer " + token);
       * requestTemplate.header("x-api-key", clientRegistration.getClientId());
       */

      final var authentication = SecurityContextHolder.getContext().getAuthentication();

      if (authentication != null && authentication.getCredentials() instanceof final AbstractOAuth2Token token) {
        requestTemplate.header("Authorization", "Bearer " + token.getTokenValue());
        requestTemplate.header("x-api-key", clientRegistration.getClientId());
      }
    };
  }

  @Bean
  public OAuth2AuthorizedClientManager authorizedClientManager() {

    final OAuth2AuthorizedClientProvider authorizedClientProvider = OAuth2AuthorizedClientProviderBuilder.builder()
        .authorizationCode()
        .build();

    final AuthorizedClientServiceOAuth2AuthorizedClientManager authorizedClientManager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(
        clientRegistrationRepository, oAuth2AuthorizedClientService);

    authorizedClientManager.setAuthorizedClientProvider(authorizedClientProvider);

    return authorizedClientManager;
  }

  @Bean
  public OAuth2AuthorizationRequestResolver pkceResolver(
      final ClientRegistrationRepository registrationRepository) {
    final var resolver = new DefaultOAuth2AuthorizationRequestResolver(registrationRepository,
        "/oauth2/authorization/");
    resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
    return resolver;
  }

}