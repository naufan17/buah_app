package com.domain.buah_app.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

import com.domain.buah_app.services.auth.UserDetailsServiceImpl;
import com.domain.buah_app.utils.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter {
  
  // private UserDetailsServiceImpl userDetailsService;
  // private JwtUtil jwtUtil;

  // protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {

  //   try {
  //     final String authHeader = request.getHeader("Authorization");
      
  //     String email = null;
  //     String jwt = null;
      
      
  //     if (authHeader != null && authHeader.startsWith("Bearer ")) {
  //       jwt = authHeader.substring(7);
        
  //       try {
  //         email = jwtUtil.extractUsername(jwt);
  //       } catch (ExpiredJwtException e) {
  //         System.out.println("JWT Token has expired: " + e.getMessage());
  //       } catch (MalformedJwtException e) {
  //         System.out.println("Invalid JWT Token: " + e.getMessage());
  //       } catch (IllegalArgumentException e) {
  //         System.out.println("Unable to get JWT Token: " + e.getMessage());
  //       }
  //     } else {
  //       System.out.println("JWT Token does not begin with Bearer String");
  //     }
      
  //     if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
  //       UserDetails userDetails = this.userDetailsService.loadUserByUsername(email);
        
  //       if (jwtUtil.validateToken(jwt, userDetails)) {
  //         UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
          
  //         authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
  //         SecurityContextHolder.getContext().setAuthentication(authentication);
  //       }
  //     }
  //     chain.doFilter(request, response);
  //   } catch (java.io.IOException ex) {
  //     System.out.println("Exception in filter chain: " + ex.getMessage());
  //   }
  // }
}
