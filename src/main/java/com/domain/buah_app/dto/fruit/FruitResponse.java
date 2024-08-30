package com.domain.buah_app.dto.fruit;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FruitResponse {

  private Long id;
  private String name;

  public FruitResponse() {}

  public FruitResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
