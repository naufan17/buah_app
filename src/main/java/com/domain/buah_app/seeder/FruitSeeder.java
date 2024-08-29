package com.domain.buah_app.seeder;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.domain.buah_app.entity.Fruit;
import com.domain.buah_app.repository.FruitRepository;

@Component
public class FruitSeeder implements CommandLineRunner {

  private final FruitRepository fruitRepository;

  public FruitSeeder(FruitRepository fruitRepository) {
    this.fruitRepository = fruitRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    fruitRepository.deleteAll();

    Fruit apple = new Fruit("Apple");
    Fruit banana = new Fruit("Banana");
    Fruit orange = new Fruit("Orange");
    Fruit mango = new Fruit("Mango");
    Fruit guava = new Fruit("Guava");
    Fruit pinnaple = new Fruit("Pinnaple");
    Fruit strawberry = new Fruit("Strawberry");
    Fruit bluberry = new Fruit("Bluberry");
    Fruit peach = new Fruit("Peach");
    Fruit plum = new Fruit("Plum");

    List<Fruit> fruits = Arrays.asList(apple, banana, orange, mango, guava, pinnaple, strawberry, bluberry, peach, plum);
    fruitRepository.saveAll(fruits);

    System.out.println("Fruit data seeded!");
  }
}