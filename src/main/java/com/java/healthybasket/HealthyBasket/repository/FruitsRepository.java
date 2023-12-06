package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.Fruits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FruitsRepository extends JpaRepository<Fruits, Long> {
    List<Fruits> findByName(String name);
    Optional<Fruits> findById(Long id);
}
