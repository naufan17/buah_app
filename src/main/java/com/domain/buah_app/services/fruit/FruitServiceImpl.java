package com.domain.buah_app.services.fruit;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.buah_app.dto.fruit.FruitRequest;
import com.domain.buah_app.dto.fruit.FruitResponse;
import com.domain.buah_app.entity.Fruit;
import com.domain.buah_app.repository.FruitRepository;

@Service
public class FruitServiceImpl implements FruitService {

  @Autowired
  private FruitRepository fruitRepository;

  @Override
  public List<FruitResponse> getAllFruits() {
    List<Fruit> fruits = fruitRepository.findAll();

    if (fruits.isEmpty()) {
      throw new RuntimeException("Fruit not found");
    }

    return fruits.stream()
      .map(fruit -> FruitResponse.builder()
        .id(fruit.getId())
        .name(fruit.getName())
        .build())
      .collect(Collectors.toList());
  }

  @Override
  public FruitResponse saveFruit(FruitRequest fruitRequest) {
    Fruit fruit = new Fruit();
    fruit.setName(fruitRequest.getName());

    try {
      Fruit savedFruit = fruitRepository.save(fruit);

      return FruitResponse.builder()
        .id(savedFruit.getId())
        .name(savedFruit.getName())
        .build();
      } catch (Exception e) {
      throw new RuntimeException("Error saving the fruit data");
    }
  }

  @Override
  public FruitResponse updateFruit(Long id, FruitRequest fruitRequest) {
    Fruit existingFruit = fruitRepository.findById(id)
      .orElseThrow(() -> new RuntimeException("Fruit not found with id " + id));

    existingFruit.setName(fruitRequest.getName());

    try {
      Fruit updatedFruit = fruitRepository.save(existingFruit);

      return FruitResponse.builder()
        .id(updatedFruit.getId())
        .name(updatedFruit.getName())
        .build();
      } catch (Exception e) {
      throw new RuntimeException("Error saving the fruit data");
    }
  }

  @Override
  public void deleteFruit(Long id) {
    Optional<Fruit> optionalFruit = fruitRepository.findById(id);

    if (optionalFruit.isPresent()) {
      fruitRepository.deleteById(id);
    } else {
      throw new RuntimeException("Fruit not found");
    }
  }
}
