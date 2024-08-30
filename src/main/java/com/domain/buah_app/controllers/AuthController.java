package com.domain.buah_app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.buah_app.dto.ApiResponseData;
import com.domain.buah_app.dto.auth.LoginRequest;
import com.domain.buah_app.dto.auth.LoginResponse;
import com.domain.buah_app.services.auth.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  
  @Autowired
  private AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<ApiResponseData<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {

    LoginResponse loginResponse = authService.login(loginRequest);

    ApiResponseData<LoginResponse> response = ApiResponseData.<LoginResponse>builder()
      .status("Success")
      .message("Login successful")
      .data(loginResponse)
      .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
