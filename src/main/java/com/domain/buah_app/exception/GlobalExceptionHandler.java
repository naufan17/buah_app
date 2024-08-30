package com.domain.buah_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.domain.buah_app.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApiResponse<String>> handleGenericException(Exception ex) {
    ApiResponse<String> response = ApiResponse.<String>builder()
      .status("Not Found")
      .message("Route not found")
      .build();

    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = { BadCredentialsException.class })
  public ResponseEntity<ApiResponse<Object>> badCredentialsException(BadCredentialsException exception) {

    ApiResponse<Object> errResponse = ApiResponse
      .<Object>builder()
      .status("Unauthorized")
      .message("Bad credentials")
      .build();

    return new ResponseEntity<>(errResponse, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(value = { UsernameNotFoundException.class })
  public ResponseEntity<ApiResponse<Object>> usernameNotFoundException(UsernameNotFoundException exception){
  
    ApiResponse<Object> errResponse = ApiResponse
      .<Object>builder()
      .status("Not Found")
      .message("User not found")
      .build();

    return new ResponseEntity<>(errResponse, HttpStatus.NOT_FOUND);
  }

}
