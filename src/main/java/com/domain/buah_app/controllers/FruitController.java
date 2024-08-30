package com.domain.buah_app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.buah_app.dto.ApiResponse;
import com.domain.buah_app.dto.ApiResponseData;
import com.domain.buah_app.dto.fruit.FruitRequest;
import com.domain.buah_app.dto.fruit.FruitResponse;
import com.domain.buah_app.entity.Fruit;
import com.domain.buah_app.repository.FruitRepository;
import com.domain.buah_app.services.fruit.FruitService;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {
  
  @Autowired
  private FruitService fruitService;

  @Autowired
  private FruitRepository fruitRepository;

  @GetMapping
  public ResponseEntity<ApiResponseData<List<FruitResponse>>> getAllFruits() {
    try {

    } catch (RuntimeException e) {
      
    }

    List<FruitResponse> fruitResponse = fruitService.getAllFruits();

    ApiResponseData<List<FruitResponse>> response = ApiResponseData.<List<FruitResponse>>builder()
      .status("Success")
      .message("Fruits retrived successfully")
      .data(fruitResponse)
      .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ApiResponseData<FruitResponse>> saveFruit(@RequestBody FruitRequest fruitRequest) {
    FruitResponse fruitResponse = fruitService.saveFruit(fruitRequest);

    ApiResponseData<FruitResponse> response = ApiResponseData.<FruitResponse>builder()
      .status("Success")
      .message("Fruit saved successfully")
      .data(fruitResponse)
      .build();

    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponseData<FruitResponse>> updateFruit(@PathVariable Long id, @RequestBody FruitRequest fruitRequest) {
    FruitResponse fruitResponse = fruitService.updateFruit(id, fruitRequest);

    ApiResponseData<FruitResponse> response = ApiResponseData.<FruitResponse>builder()
      .status("Success")
      .message("Fruit updated successfully")
      .data(fruitResponse)
      .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteFruit(@PathVariable("id") Long id) {
    try {
      fruitService.deleteFruit(id);

      ApiResponse response = ApiResponse.builder()
        .status("Success")
        .message("Fruit deleted successfully")
        .build();

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (RuntimeException e) {
      ApiResponse response = ApiResponse.builder()
        .status("Not Found")
        .message(e.getMessage())
        .build();

      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
  }
}
