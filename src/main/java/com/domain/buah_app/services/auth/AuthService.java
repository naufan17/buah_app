package com.domain.buah_app.services.auth;

import com.domain.buah_app.dto.auth.LoginRequest;
import com.domain.buah_app.dto.auth.LoginResponse;

public interface AuthService {
  public LoginResponse login(LoginRequest request);
}
