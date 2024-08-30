package com.domain.buah_app.dto.fruit;

public class FruitRequest {

  private String name;

  public FruitRequest() {}

  public FruitRequest(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
