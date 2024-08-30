package com.domain.buah_app.services.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.domain.buah_app.dto.auth.LoginRequest;
import com.domain.buah_app.dto.auth.LoginResponse;
import com.domain.buah_app.entity.User;
import com.domain.buah_app.repository.UserRepository;
import com.domain.buah_app.utils.JwtUtil;

@Service
public class AuthServiceImpl implements AuthService{

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired 
  private JwtUtil jwtUtil;

  @Override
  public LoginResponse login(LoginRequest request) {
    Optional<User> user = this.userRepository.findByEmail(request.getEmail());

    if (user.isEmpty()) {
      throw new RuntimeException("User not found");
    }

    if (!passwordEncoder.matches(request.getPassword(), user.get().getPassword())) {
      throw new BadCredentialsException("Invalid credentials");
    }

    String token = this.jwtUtil.generateToken(request.getEmail());

    return LoginResponse.builder()
      .accessToken(token)
      .build();
  }    
} 
