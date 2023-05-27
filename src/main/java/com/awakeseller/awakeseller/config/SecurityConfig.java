package com.awakeseller.awakeseller.config;

import static org.springframework.http.HttpMethod.GET;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain configure(final HttpSecurity http)
      throws Exception {
    http
        .cors()
        .and()
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeHttpRequests(configurer -> configurer
            .requestMatchers("/error").permitAll()
            // permitir swagger sin autenticar
            .requestMatchers(GET, "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                "/v3/api-docs/**",
                "/swagger-ui/**")
            .permitAll()
            .anyRequest().authenticated())
        .exceptionHandling(e -> e
            .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
        .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
        .oauth2Client();

    return http.build();
  }

  @Bean
  EtsyAuthenticationFilter authenticationTokenFilterBean() throws Exception {
    return new EtsyAuthenticationFilter();
  }

  @Bean
  WebMvcConfigurer corsMappingConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(final CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("https://localhost:3001")
            .allowCredentials(true)
            .allowedMethods("*");

      }
    };
  }
}
