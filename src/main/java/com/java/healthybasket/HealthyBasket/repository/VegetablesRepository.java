package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VegetablesRepository extends JpaRepository<Vegetables, Long> {
    List<Vegetables> findByName(String name);
    Optional<Vegetables> findById(Long id);
}
