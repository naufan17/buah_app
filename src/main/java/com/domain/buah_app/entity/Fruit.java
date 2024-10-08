package com.domain.buah_app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits")
public class Fruit implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(length = 100, nullable = false, unique = true)
  private String name;

  // @Column(nullable = false, columnDefinition = "boolean default false")
  // private boolean deleted = false;

  // @Column(name="deleted_at")
  // private LocalDateTime deletedAt;

  public Fruit() {}

  public Fruit(String name) {
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

  // public boolean isDeleted() {
  //   return deleted;
  // }

  // public void setDeleted(boolean deleted) {
  //   this.deleted = deleted;
  // }

  // public LocalDateTime getDeletedAt() {
  //   return deletedAt;
  // }

  // public void setDeletedAt(LocalDateTime deletedAt) {
  //   this.deletedAt = deletedAt;
  // }
}