package com.domain.buah_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.buah_app.models.Fruit;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {
  
}
