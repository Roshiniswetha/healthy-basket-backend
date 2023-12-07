package com.java.healthybasket.HealthyBasket.repository;

import com.java.healthybasket.HealthyBasket.model.DailyEssentials;
import com.java.healthybasket.HealthyBasket.model.Vegetables;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DailyEssentialsRepository extends JpaRepository<DailyEssentials, Long> {
    List<DailyEssentials> findByName(String name);
    Optional<DailyEssentials> findById(Long id);
}
