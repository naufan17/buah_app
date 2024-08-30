package com.domain.buah_app.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

  private String status;
  private String message;

  public ApiResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
