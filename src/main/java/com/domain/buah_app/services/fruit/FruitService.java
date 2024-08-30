package com.domain.buah_app.services.fruit;

import java.util.List;

import com.domain.buah_app.dto.fruit.FruitRequest;
import com.domain.buah_app.dto.fruit.FruitResponse;
import com.domain.buah_app.entity.Fruit;

public interface FruitService {
  
  List<FruitResponse> getAllFruits();

  FruitResponse saveFruit(FruitRequest fruitRequest);
  
  FruitResponse updateFruit(Long id, FruitRequest fruitRequest);
  
  void deleteFruit(Long id);
}
