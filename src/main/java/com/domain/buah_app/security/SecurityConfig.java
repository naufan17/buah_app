package com.domain.buah_app.security;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.domain.buah_app.services.auth.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Bean
  // public AuthenticationProvider authenticationProvider() {
  //   DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
  //   authenticationProvider.setUserDetailsService(this.userDetailsService);
  //   authenticationProvider.setPasswordEncoder(this.passwordEncoder());

  //   return authenticationProvider;
  // }

  // @Bean
  // public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
  //   return authConfig.getAuthenticationManager();
  // }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
      .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer
        .configurationSource(this.corsConfigurationSource()))
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/login", "/api/fruits", "/api/fruits/{id}").permitAll()
        .anyRequest().authenticated());
      // .authenticationProvider(authenticationProvider());
      // .addFilterBefore(this.jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
  
    return http.build();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(List.of("*"));
    configuration.setAllowedMethods(List.of("*"));
    configuration.setAllowedHeaders(List.of("*"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
  }
}